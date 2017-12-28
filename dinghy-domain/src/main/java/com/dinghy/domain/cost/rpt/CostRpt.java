package com.dinghy.domain.cost.rpt;

import com.dinghy.domain.cost.Cost;

import java.util.List;

/**
 * Created by dinghy on 2017/9/29.
 */
public interface CostRpt {

    void put(Cost cost);

    List<Cost> findAll();

    /**
     * 查询资费分页查询
     * @param page 页码
     * @param pageSize 一页总数
     * @return
     */
    List<Cost> findByPage(int page,int pageSize);

    /**
     * 查询总页数
     * @param pageSize
     * @return
     */
    int findTotalPage(int pageSize);

    /**
     * 根据Id查询资费数据
     * @param id
     * @return
     */
    Cost findById(Long id);

    /**
     * 保存修改资费
     * @param cost
     */
    void update(Cost cost);

    void deleteCost(Cost cost);

}
