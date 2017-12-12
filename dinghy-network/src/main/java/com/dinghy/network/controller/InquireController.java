package com.dinghy.network.controller;

import com.dinghy.domain.pay.entity.InquireResult;
import com.dinghy.domain.pay.service.PayService;
import com.dinghy.domain.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by dinghy on 2017/11/28.
 */
@Controller
@RequestMapping("index")
public class InquireController {

    @Resource
    private PayService payService;

    @RequestMapping("/payInquire")
    @ResponseBody
    public ModelAndView inquirePay(String orderNo) {
        ModelAndView modelAndView = new ModelAndView("payInquire");
        if (StringUtils.isNotBlank(orderNo)) {
            InquireResult result = payService.InquirePay(orderNo);
            modelAndView.addObject("result", result);
            return modelAndView;
        }else {
            return modelAndView;
        }
    }
}
