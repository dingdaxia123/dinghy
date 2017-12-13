package com.dinghy.web.controller;

import com.dinghy.domain.user.User;
import com.dinghy.domain.user.UserResult;
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
        return "ceshi";
    }

    @RequestMapping("login")
    public String login(String name, String password, HttpServletRequest request, HttpSession httpSession) {
        User user = userService.getUser(name, password);
        httpSession.setAttribute("user", user);
        String CharacterEncoding = "UTF-8";
        try {
            request.setCharacterEncoding(CharacterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (user != null) {
            logger.info("success:登录成功！");
            return "redirect:main";
        } else {
            return "login";
        }
    }

    @RequestMapping("register")
    public ModelAndView register(String name, String password) {
        ModelAndView modelAndView;
        String result = userService.save(name, password);
        if(result.equals(UserResult.Success.getText())){
            modelAndView = new ModelAndView("redirect:login");
            modelAndView.addObject("result", result);
            logger.info("success:用户储存成功");
            return modelAndView;
        }else if(result.equals(UserResult.NameRepeat.getText())){
            modelAndView = new ModelAndView("register");
            modelAndView.addObject("result", result);
            logger.error("error:用户已存在");
            return modelAndView;
        }else{
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

    @RequestMapping("main")
    public String main() {
        return "main";
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
