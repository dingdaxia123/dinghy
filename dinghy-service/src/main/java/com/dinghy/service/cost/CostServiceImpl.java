package com.dinghy.service.cost;

import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.CostType;
import com.dinghy.domain.cost.rpt.CostRpt;
import com.dinghy.domain.cost.service.CostService;
import com.dinghy.domain.util.StringUtils;
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
        if (name != null && name.equals("")) {
            Cost cost = new Cost(name);
            costRpt.put(cost);
            return "ok";
        } else {
            return null;
        }
    }

    @Override
    public String saveCost(String name, String baseDuration, String baseCost, String unitCost, String descr, String type) {
        if (StringUtils.isNotBlank(name)) {
            if (type.equals("0")) {
                Cost cost = new Cost(descr, unitCost, baseCost, baseDuration, name, CostType.Monthly);
                costRpt.put(cost);
                return "ok";
            } else if (type.equals("1")) {
                Cost cost = new Cost(descr, unitCost, baseCost, baseDuration, name, CostType.Package);
                costRpt.put(cost);
                return "ok";
            } else {
                Cost cost = new Cost(descr, unitCost, baseCost, baseDuration, name, CostType.Time);
                costRpt.put(cost);
                return "ok";
            }
        }
        return "error";
    }

}
