package com.dinghy.domain.pay;

public enum PayResultCode {
	ERR1001("支付请求参数含有必须传输的参数为空值"),
	ERR1002("支付请求金额格式不正确"),
	ERR1003("该支付商户不存在"),
	ERR1004("订单已存在"),
	ERR1005("商户支付操作未开通，请联系商户"),
	ERR1006("交易金额超过限制"),
	ERR1007("IP域名对应不正确，交易发生错误"),
	ERR1008("签名信息不匹配"),
	ERR1009("交易发生异常，请返回商户网站重新提交支付"),
	ERR1010("系统异常"),
	ERR1011("支付风险受限"),
	ERR1012("交易超限"),
	ERR1014("日期格式不正确"),
	ERR1015("月交易超限"),
	ERR1016("请设置商户下发秘钥"),
	ERR1017("支付方式不正确"),
	ERR1018("商户订单号超过50位"),
	ERR1019("通知地址不合法"),
	ERR1020("请设置商户支付秘钥"),
	ERR1021("查询时间超时"),
	ERR1022("支付方式不正确"),
	ERR1023("字符编码错误"),
	ERR1024("扫码支付商户入驻失败"),
	ERR1025("扫码支付商户入驻批次号已存在"),
	ERR1026("扫码支付商户入驻查询请求流水不存在");
	private final String text;

	public String getText() {
		return text;
	}

	public String getLabel() {
		return toString();
	}

	PayResultCode(String text) {
		this.text = text;
	}

	public static PayResultCode getByText(String text){
		PayResultCode[] payResultCodes = PayResultCode.values();
		for(PayResultCode payResultCode:payResultCodes){
			if(payResultCode.getText().equals(text)){
				return payResultCode;
			}
		}
		return null;
	}
	
}
