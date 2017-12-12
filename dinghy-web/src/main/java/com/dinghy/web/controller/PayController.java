package com.dinghy.web.controller;

import com.dinghy.domain.order.Order;
import com.dinghy.domain.order.Refund;
import com.dinghy.domain.order.rpt.OrderRpt;
import com.dinghy.domain.pay.entity.PayEntity;
import com.dinghy.domain.pay.service.PayService;
import com.dinghy.domain.util.Md5Utils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by dinghy on 2017/11/8.
 */
@Controller
@RequestMapping("index")
public class PayController {
//    Logger

    @Resource
    private PayService payService;

    @Resource
    private OrderRpt orderRpt;


    @RequestMapping("/pay")
    public ModelAndView requestPay() {
        ModelAndView view = new ModelAndView("pay");
        PayEntity payEntity = payService.pay("0.01");
        view.addObject("payEntity", payEntity);
        return view;
    }

    @RequestMapping("/payAdviceUrl")
    @ResponseBody
    public String adviceUrl(HttpServletRequest request) {
        String CharacterEncoding = "UTF-8";
        try {
            request.setCharacterEncoding(CharacterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String IP = request.getRemoteAddr();
        String MerNo = request.getParameter("MerNo");
        String BillNo = request.getParameter("BillNo");
        String OrderNo = request.getParameter("OrderNo");
        String Amount = request.getParameter("Amount");
        String Succeed = request.getParameter("Succeed");
        String Result = request.getParameter("Result");
        String SignInfo = request.getParameter("SignInfo");
        Md5Utils md5 = new Md5Utils();
        String md5src = "MerNo=" + MerNo + "&" + "BillNo=" + BillNo + "&" + "OrderNo=" + OrderNo + "&" + "Amount=" + Amount + "&" + "Succeed=" + Succeed + "&" + "zhuxiang";
        String md5sign; //MD5加密后的字符串
        md5sign = md5.getMD5ofStr(md5src);//MD5检验结果
        if (md5sign.equals(SignInfo)) {
            Order order = new Order(MerNo, BillNo, Amount, OrderNo, Succeed, Result, SignInfo, IP);
            payService.save(order);
            return "ok";
        } else {
            return "error";
        }
    }
}
