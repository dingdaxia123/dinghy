package com.dinghy.web.controller;


import com.dinghy.domain.cost.service.CostService;
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

}
