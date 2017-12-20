package com.dinghy.web.controller;


import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.rpt.CostRpt;
import com.dinghy.domain.cost.service.CostService;
import com.dinghy.domain.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dinghy on 2017/9/30.
 */

@Controller
@RequestMapping("index")
public class CostController {

//    private List<Cost> costList;
    private int page=1;
    private int pageSize=4;
    private int totalPage;

    @Resource
    private CostService costService;

    @Resource
    private CostRpt costRpt;

    @RequestMapping("fee_add")
    public ModelAndView addCost(String name, String baseDuration, String baseCost, String unitCost, String descr, String radFeeType) {
        ModelAndView modelAndView;
        if (StringUtils.isNotBlank(name)) {
            modelAndView = new ModelAndView("fee_list");
            String result = costService.saveCost(name, baseDuration, baseCost, unitCost, descr, radFeeType);
            modelAndView.addObject("result", result);
            return modelAndView;
        }
        modelAndView = new ModelAndView("fee_add");
        return modelAndView;
    }

    @RequestMapping("fee_list")
    public ModelAndView listCost(String page1) {
        ModelAndView modelAndView = new ModelAndView("fee_list");
//        List<Cost> costList = costRpt.findAll();
        List<Cost> costList= costRpt.findByPage(page, pageSize);
        modelAndView.addObject("costList", costList);
        totalPage=costRpt.findTotalPage(pageSize);
        return modelAndView;
    }

}
