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
//        logger.info("**********��ʼ�����̻�֧���ϴ�����*********");
        logger.info("�����ַ��" + url);
        logger.info("ip��" + ip);
        logger.info("�̻���MerNo��" + MerNo);
        logger.info("�̻�������BillNo��" + BillNo);
        logger.info("���׽��Amount��" + Amount);
        logger.info("ҳ�淵��ReturnURL��" + ReturnURL);
        logger.info("����������AdviceURL��" + AdviceURL);
        logger.info("SignInfo��" + SignInfo);
        logger.info("��������ʱ��OrderTime��" + OrderTime);
        logger.info("���б���defaultBankNumber��" + defaultBankNumber);
        logger.info("֧����ʽpayType��" + payType);
        logger.info("��עRemark��" + Remark);
        logger.info("��Ʒ��Ϣproducts��" + products);
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
