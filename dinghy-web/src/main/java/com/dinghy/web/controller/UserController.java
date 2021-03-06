package com.dinghy.web.controller;

import com.dinghy.domain.user.User;
import com.dinghy.domain.user.UserResult;
import com.dinghy.domain.user.rpt.UserRpt;
import com.dinghy.domain.user.service.UserService;
import com.dinghy.domain.util.CaptchaUtil;
import com.dinghy.domain.util.Pagination;
import com.dinghy.domain.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by dinghy on 2017/11/1.
 */
@Controller
@RequestMapping("index")
public class UserController {
    Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private UserService userService;
    @Resource
    private UserRpt userRpt;
    @ResponseBody
    @RequestMapping("user")
    public String saveUser(String name, String password) {
        ModelMap modelMap = new ModelMap();
//        userService.save(name, password);
        User type = userService.getUser("admin", "123456");
        return "ceshi";
    }

    @RequestMapping("login")
    public String login(String accountNumber, String password, HttpServletRequest request, HttpSession httpSession, String yanZ) {
        User user = userService.getUser(accountNumber, password);
        String toUpperCase = null;
        httpSession.setAttribute("user", user);
        String code = (String) request.getSession().getAttribute("validateCode");
        if (yanZ != null) {
            toUpperCase = yanZ.toUpperCase();
        }

        String CharacterEncoding = "UTF-8";
        try {
            request.setCharacterEncoding(CharacterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (user != null && toUpperCase.equals(code)) {
            logger.info("success:登录成功");
            return "redirect:main";
        } else {
            return "login";
        }
    }

    @RequestMapping("register")
    public ModelAndView register(String name, String password, String phone, String email, String accountNumber) {
        ModelAndView modelAndView;
        String result = userService.save(name, password, phone, email, accountNumber);
        if (result.equals(UserResult.Success.getText())) {
            modelAndView = new ModelAndView("redirect:login");
            modelAndView.addObject("result", result);
            logger.info("success:用户储存成功?");
            return modelAndView;
        } else if (result.equals(UserResult.NameRepeat.getText())) {
            modelAndView = new ModelAndView("register");
            modelAndView.addObject("result", result);
            logger.error("error:用户已存在");
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("register");
            return modelAndView;
        }
    }

    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(String name, String password) {
        ModelAndView modelAndView;
        if (StringUtils.isNotBlank(name) || StringUtils.isNotBlank(password)) {
            String result = userService.deleteUser(name, password);
            modelAndView = new ModelAndView("delete");
            modelAndView.addObject("result", result);
            return modelAndView;
        }
        modelAndView = new ModelAndView("delete");

        return modelAndView;
    }

    @RequestMapping("findUser")
    public ModelAndView findUser(String name) {
        ModelAndView modelAndView;
        if (StringUtils.isNotBlank(name)) {
            List<User> userList = userService.findUser(name);
            modelAndView = new ModelAndView("find");
            modelAndView.addObject("userList", userList);
            return modelAndView;
        }
        modelAndView = new ModelAndView("find");
        return modelAndView;
    }

    @RequestMapping("getUser")
    public ModelAndView getUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("user_info");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("updateUser")
    public ModelAndView updateUser(HttpServletRequest request, String name, String phone, String email) {
        ModelAndView modelAndView;
        User user = (User) request.getSession().getAttribute("user");
        String accountNumber = user.getAccountNumber();
        String password = user.getPassword();
        User result = userService.getUser(accountNumber, password);
        if (result != null && StringUtils.isBlank(name)) {
            modelAndView = new ModelAndView("updateUser");
            return modelAndView;
        }
        userService.updateUser(name, phone, email, user);
        modelAndView = new ModelAndView("redirect:getUser");
        return modelAndView;
    }

    @RequestMapping("updatePwd")
    public ModelAndView updatePwd(HttpServletRequest request, String password2,String password1 ) {
        /**
         * password1页面上输入的旧密码，password页面上输入的新密码。js页面已经判断新密码输入是否一致
         */
        ModelAndView modelAndView;
        User user = (User) request.getSession().getAttribute("user");
        String password = user.getPassword();//user里获取的原始密码
        if (password.equals(password1)) {
            userService.updatePwd(password2, user);
            modelAndView = new ModelAndView("redirect:main");
            return modelAndView;
        }
        modelAndView = new ModelAndView("user_modi_pwd");
        return modelAndView;
    }


    @RequestMapping("main")
    public String main() {
        return "main";
    }

    @RequestMapping("admin_add")
    public ModelAndView addCost(String name, String password,String password1, String phone, String email, String accountNumber) {
        ModelAndView modelAndView;
        if (StringUtils.isNotBlank(name)) {
            modelAndView = new ModelAndView("admin_list");
            String result = userService.addSave(name,password,phone,password1,email,accountNumber);
            modelAndView.addObject("result", result);
            return modelAndView;
        }
        modelAndView = new ModelAndView("admin_add");
        return modelAndView;
    }
    @RequestMapping("admin_list")
    public ModelAndView listCost(String page) {
        List<User> userList;
        ModelAndView modelAndView = new ModelAndView("admin_list");
        if (page != null) {
            userList = userRpt.findByPage(Integer.valueOf(page), 1);
        } else {
            userList = userRpt.findByPage(1, 1);
        }
        Pagination pag = new Pagination();
        pag.setList(userList);
        pag.setTotalCount(userList.size());
        pag.setTotalPage(userRpt.findTotalPage(1));
        if (page != null) {
            pag.setPageNo(Integer.valueOf(page));
        }
        modelAndView.addObject("pager", pag);
        modelAndView.addObject("page", pag.getPageNo());
        return modelAndView;
    }

    @RequestMapping("/check")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 通知浏览器不要缓存
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        CaptchaUtil util = CaptchaUtil.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();
        request.getSession().setAttribute("code", code);
        // 输出打web页面
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
    }

    public static void main(String[] args) {
        Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level啊 AAAA");
        logger.fatal("fatal level");
        System.out.println("啊啊的");
    }

}
