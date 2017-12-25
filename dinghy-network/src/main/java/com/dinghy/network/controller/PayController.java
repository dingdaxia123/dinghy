package com.dinghy.network.controller;

import com.dinghy.domain.exception.SkyException;
import com.dinghy.domain.pay.PayResultCode;
import com.dinghy.domain.pay.service.PayService;
import com.dinghy.domain.util.StringUtils;
import com.dinghy.network.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dinghy on 2017/12/25.
 */
@Controller
public class PayController extends BaseController{

    @Resource
    private PayService payService;

    @RequestMapping("/dhy/pay")
    public ModelAndView pay(String MerNo, String BillNo, String Amount,
                            String ReturnURL, String AdviceURL, String SignInfo,
                            String OrderTime, String defaultBankNumber,
                            String Remark, String products, String payType,HttpServletRequest request)throws Exception{
        String url = getURL(request);
        String ip = getIpAddr(request);
//        logger.info("**********开始接受商户支付上传参数*********");
        logger.info("请求地址：" + url);
        logger.info("ip：" + ip);
        logger.info("商户号MerNo：" + MerNo);
        logger.info("商户订单号BillNo：" + BillNo);
        logger.info("交易金额Amount：" + Amount);
        logger.info("页面返回ReturnURL：" + ReturnURL);
        logger.info("服务器返回AdviceURL：" + AdviceURL);
        logger.info("SignInfo：" + SignInfo);
        logger.info("交易请求时间OrderTime：" + OrderTime);
        logger.info("银行编码defaultBankNumber：" + defaultBankNumber);
        logger.info("支付方式payType：" + payType);
        logger.info("备注Remark：" + Remark);
        logger.info("物品信息products：" + products);
        if(StringUtils.isBlank(ReturnURL) && StringUtils.isBlank(AdviceURL) && StringUtils.isBlank(BillNo)
                && StringUtils.isBlank(OrderTime) && StringUtils.isBlank(Amount)) {
                throw new SkyException(PayResultCode.ERR1001.getText());
        }
        String result = payService.pay(MerNo, BillNo, Amount, ReturnURL, AdviceURL, SignInfo,
                OrderTime, defaultBankNumber, Remark, products, payType);
        ModelAndView modelAndView = new ModelAndView("pay");
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
