package com.dinghy.service.cost;

import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.rpt.CostRpt;
import com.dinghy.domain.cost.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dinghy on 2017/9/29.
 */
@Service
public class CostServiceImpl implements CostService {

    @Resource
    private CostRpt costRpt;

    public String getCost(String name) {
        if(name != null && name.equals("")){
            Cost cost = new Cost(name);
            costRpt.put(cost);
            return "ok";
        }else {
            return null;
        }
    }
}
