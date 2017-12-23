package com.dinghy.web.controller;


import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.rpt.CostRpt;
import com.dinghy.domain.cost.service.CostService;
import com.dinghy.domain.util.CommonService;
import com.dinghy.domain.util.Pagination;
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
//    private int pageNo=1;
//    private int pageSize=4;
//    private int totalPage;

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
    public ModelAndView listCost(String page) {
        List<Cost> costList;
        ModelAndView modelAndView = new ModelAndView("fee_list");
        if (page != null) {
            costList = costRpt.findByPage(Integer.valueOf(page), 1);
        } else {
            costList = costRpt.findByPage(1, 1);
        }
        Pagination pag = new Pagination();
        pag.setList(costList);
        pag.setTotalCount(costList.size());
//        if (costList.size() / pag.getPageSize() == 0)
//            pag.setTotalPage(costList.size() / pag.getPageSize());
//        else
//            pag.setTotalPage(costList.size() / pag.getPageSize() + 1);
//        if (page != null) {
//            pag.setPageNo(Integer.valueOf(page));
//        }
        pag.setTotalPage(costRpt.findTotalPage(1));
        if(page != null){
            pag.setPageNo(Integer.valueOf(page));
        }

        int tot = pag.getTotalPage();

        modelAndView.addObject("pager", pag);
        return modelAndView;
    }
    @RequestMapping("fee_modi")
    public ModelAndView updateCost(String id, String name, String baseDuration, String baseCost, String unitCost, String descr, String radFeeType) {
        ModelAndView modelAndView;
        if (StringUtils.isNotBlank(id)) {
            modelAndView = new ModelAndView("fee_modi");
            modelAndView.addObject("id", id);
            Cost cost = costRpt.findById(Long.valueOf(id));
            modelAndView.addObject("name", cost.getName());
            modelAndView.addObject("radFeeType", cost.getCostType().getText());
            modelAndView.addObject("baseDuration", cost.getBaseDuration());
            modelAndView.addObject("baseCost",cost.getBaseCost());
            modelAndView.addObject("status",cost.getStatus().getText());
            modelAndView.addObject("descr", cost.getDescr());
            return modelAndView;

        }else {

            return  null;
        }

    }

}
