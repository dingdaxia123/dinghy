package com.dinghy.domain.cost;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dinghy on 2017/9/28.
 */
public class Cost implements Serializable{
    private Long id;// 主键
    private String name;// 资费名称
    private Integer baseDuration;// 在线时长
    private Double baseCost;// 基本费用
    private Double unitCost;// 单位费用
    private String status;// 状态
    private String descr;// 资费说明
    private Date createTime;// 创建日期
    private Date startTime;// 启用日期
    private String costType;// 资费类型


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

    public Integer getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(Integer baseDuration) {
        this.baseDuration = baseDuration;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }
}
