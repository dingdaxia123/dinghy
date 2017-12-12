import com.dinghy.domain.cost.Cost;
import com.dinghy.domain.cost.rpt.CostRpt;
import com.dinghy.domain.cost.service.CostService;
import com.dinghy.domain.user.User;
import com.dinghy.domain.user.rpt.UserRpt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dinghy on 2017/9/29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/applicationContext.xml"})
public class TestCost {

    @Resource
    private CostRpt costRpt;

    @Resource
    private UserRpt userRpt;

    @Test
    public void testSave(){
//        Cost cost = new Cost("丁大侠1");
//        cost.setStatus("1");
//        costRpt.put(cost);
        User user = new User("ddx","123456");
        userRpt.put(user);
    }

    @Test
    public void testLog(){
        Logger logger = (Logger) LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level啊啊啊");
        logger.warn("warn level");
        logger.error("error level啊啊啊");
        logger.fatal("fatal level是是是");
    }
}
