package com.dinghy.web.controller;

import com.dinghy.domain.user.User;
import com.dinghy.domain.user.service.UserService;
import com.dinghy.domain.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    @ResponseBody
    @RequestMapping("user")
    public String saveUser(String name, String password) {
        ModelMap modelMap = new ModelMap();
        userService.save(name, password);
        User type = userService.getUser("admin", "123456");
//        modelMap.addAttribute("type" , type);
        return "ceshi";
    }

    //    @ResponseBody
    @RequestMapping("login")
    public String login(String name, String password, HttpServletRequest request, HttpSession httpSession) {
//        ModelAndView view;
        User user = userService.getUser(name, password);
        httpSession.setAttribute("user", user);
        String CharacterEncoding = "UTF-8";
        try {
            request.setCharacterEncoding(CharacterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        String ip = request.getRemoteAddr();
//        String MerNo = "16886";
//        String BillNo = request.getParameter("BillNo");
//        String OrderNo=request.getParameter("OrderNo");
//        String Amount = request.getParameter("Amount");
//        String tradeOrder = request.getParameter("tradeOrder");
//        String Succeed = request.getParameter("Succeed");
//        String Result = request.getParameter("Result");
//        String SignInfo= request.getParameter("SignInfo");
        if (user != null) {
//            view =new ModelAndView("ceshi");
//            view.addObject("password" , password);
//            view.addObject("name" , name);
            return "redirect:main";
        } else {
//            view = new ModelAndView();
//            view.setViewName("login");
            return "login";
        }
    }

    @RequestMapping("register")
    public String register(String name, String password) {
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
            logger.error("success:用户存储成功");
            userService.save(name, password);
            return "redirect:login";
        } else {
            return "register";
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

    @RequestMapping("main")
    public String main() {
        return "ceshi";
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
