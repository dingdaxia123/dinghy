package com.dinghy.domain.cost;

/**
 * Created by dinghy on 2017/12/19.
 */
public enum CostStatus {
    Open("��ͨ"),
    Close("�ر�");
    private final String text;

    CostStatus(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

}
