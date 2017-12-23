package com.dinghy.domain.cost;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dinghy on 2017/9/28.
 */
public class Cost implements Serializable{
    private Long id;// 主键
    private String name;// 资费名称
    private String baseDuration;// 在线时长
    private String baseCost;// 基本费用
    private String unitCost;// 单位费用
    private CostStatus status = CostStatus.Close ;// 状态
    private String descr;// 资费说明
    private Date createTime = new Date();// 创建日期
    private Date startTime = new Date();// 启用日期
    private CostType costType;// 资费类型

    public Cost(String descr, String unitCost, String baseCost, String baseDuration, String name, CostType costType) {
        this.descr = descr;
        this.unitCost = unitCost;
        this.baseCost = baseCost;
        this.baseDuration = baseDuration;
        this.name = name;
        this.costType = costType;
    }

    public Cost(){}

    public Cost(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(String baseDuration) {
        this.baseDuration = baseDuration;
    }

    public String getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(String baseCost) {
        this.baseCost = baseCost;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public CostStatus getStatus() {
        return status;
    }

    public void setStatus(CostStatus status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public CostType getCostType() {
        return costType;
    }

    public void setCostType(CostType costType) {
        this.costType = costType;
    }

    public Long getId() {
        return id;
    }
}
