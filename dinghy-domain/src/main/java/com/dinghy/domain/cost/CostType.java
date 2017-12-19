package com.dinghy.domain.cost;

/**
 * Created by dinghy on 2017/12/19.
 */
public enum CostType {
    Monthly("包月"),
    Package("套餐"),
    Time("计时");

    private final String text;

    CostType(String text){this.text = text;}

    public String getText(){return text;}
}
