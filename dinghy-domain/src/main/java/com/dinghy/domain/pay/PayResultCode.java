package com.dinghy.domain.pay;

public enum PayResultCode {
	ERR1001("֧������������б��봫��Ĳ���Ϊ��ֵ"),
	ERR1002("֧���������ʽ����ȷ"),
	ERR1003("��֧���̻�������"),
	ERR1004("�����Ѵ���"),
	ERR1005("�̻�֧������δ��ͨ������ϵ�̻�"),
	ERR1006("���׽�������"),
	ERR1007("IP������Ӧ����ȷ�����׷�������"),
	ERR1008("ǩ����Ϣ��ƥ��"),
	ERR1009("���׷����쳣���뷵���̻���վ�����ύ֧��"),
	ERR1010("ϵͳ�쳣"),
	ERR1011("֧����������"),
	ERR1012("���׳���"),
	ERR1014("���ڸ�ʽ����ȷ"),
	ERR1015("�½��׳���"),
	ERR1016("�������̻��·���Կ"),
	ERR1017("֧����ʽ����ȷ"),
	ERR1018("�̻������ų���50λ"),
	ERR1019("֪ͨ��ַ���Ϸ�"),
	ERR1020("�������̻�֧����Կ"),
	ERR1021("��ѯʱ�䳬ʱ"),
	ERR1022("֧����ʽ����ȷ"),
	ERR1023("�ַ��������"),
	ERR1024("ɨ��֧���̻���פʧ��"),
	ERR1025("ɨ��֧���̻���פ���κ��Ѵ���"),
	ERR1026("ɨ��֧���̻���פ��ѯ������ˮ������");
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
