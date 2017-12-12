package com.dinghy.web.controller;

import com.dinghy.domain.order.Refund;
import com.dinghy.domain.order.rpt.OrderRpt;
import com.dinghy.domain.pay.service.PayService;
import com.dinghy.domain.util.Md5Utils;
import com.dinghy.domain.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by dinghy on 2017/11/28.
 */
@Controller
@RequestMapping("index")
public class RefundController {

    @Resource
    private OrderRpt orderRpt;

    @Resource
    private PayService payService;

    @RequestMapping("/refundAdviceUrl")
    @ResponseBody
    public String refundAdviceUrl(HttpServletRequest request){
        String CharacterEncoding = "UTF-8";
        try {
            request.setCharacterEncoding(CharacterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String IP = request.getRemoteAddr();
        String merCode = request.getParameter("merCode");
        String orderNumber = request.getParameter("orderNumber");
        String orderTime = request.getParameter("orderTime");
        String orderAmount = request.getParameter("orderAmount");
        String refundAmount = request.getParameter("refundAmount");
        String Sign = request.getParameter("Sign");
        String remark = request.getParameter("remark");
        String refundStatus = request.getParameter("refundStatus");
        String refundNumber = request.getParameter("refundNumber");
        Md5Utils md5 = new Md5Utils();
        String md5src = "merCode="+merCode+"&orderNumber="+orderNumber+"&orderTime="+orderTime+
                "&orderAmount="+orderAmount+"&refundAmount="+refundAmount+"&refundStatus="+refundStatus;
        String md5sign = md5.getMD5ofStr(md5src);
        if(md5sign.equals(Sign)){
            Refund refund = orderRpt.getRefund(refundNumber);
            refund.setIp(IP);
            refund.setMerCode(merCode);
            refund.setOrderNumber(orderNumber);
            refund.setOrderTime(orderTime);
            refund.setOrderAmount(orderAmount);
            refund.setSign(Sign);
            refund.setRemark(remark);
            refund.setRefundStatus(refundStatus);
            refund.setRefundNumber(refundNumber);
            payService.save(refund);
        }
        return null;
    }

    @RequestMapping("/refund")
    @ResponseBody
    public ModelAndView refund(String refundAmount, String orderNumber){
        ModelAndView modelAndView = new ModelAndView("refund");
        if(StringUtils.isNotBlank(refundAmount) && StringUtils.isNotBlank(orderNumber)) {
            payService.refund(refundAmount, orderNumber, "http://180.173.165.224:10045/index/refundAdviceUrl");
            return modelAndView;
        }else {
            return modelAndView;
        }
    }
}
