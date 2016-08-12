import com.zealot.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by GhostJun on 16/8/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MyBatisTest {
    @Autowired
    private UserService userService;
    private static Logger logger = Logger.getLogger(MyBatisTest.class);

    @Test
    public void test1() {
        Integer id = 1;
        String name = userService.getUserNameById(id);
        logger.info("姓名：" + name);

    }
}
