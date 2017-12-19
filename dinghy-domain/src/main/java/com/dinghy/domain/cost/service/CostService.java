package com.dinghy.domain.cost.service;


/**
 * Created by dinghy on 2017/9/29.
 */
public interface CostService {

    /**
     * 获取用户信息
     * @param name 用户名字
     * @return
     */
    String getCost(String name);

    String saveCost(String name, String baseDuration, String baseCost, String unitCost, String descr, String type);

}
