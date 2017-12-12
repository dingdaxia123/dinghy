package com.dinghy.network.controller;


import com.dinghy.domain.cost.service.CostService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dinghy on 2017/9/30.
 */

@Controller
public class CostController {

    @Resource
    private CostService costService;

    @RequestMapping(value = "getCost")
    @ResponseBody
    public String getCost(String name){
        ModelMap modelMap = new ModelMap();
        String type = costService.getCost(name);
        modelMap.addAttribute("type" , type);
        return "ceshi";

    }
    public static void main(String[] args) {
        Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level°¡ AAAA");
        logger.fatal("fatal level");
    }

}
