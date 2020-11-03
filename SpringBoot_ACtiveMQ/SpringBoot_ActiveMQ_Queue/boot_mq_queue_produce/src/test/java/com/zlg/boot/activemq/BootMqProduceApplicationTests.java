package com.zlg.boot.activemq;

import com.zlg.boot.activemq.produce.Queue_Produce;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 单元测试（非必须，仅为演示）
 */

/*// 加载主类
@SpringBootTest(classes = BootMqProduceApplication.class)
// 加载 Spring 的 junit
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 web
@WebAppConfiguration*/
class BootMqProduceApplicationTests {
    /*// 引入生产者类
    @Autowired      // 这个是 Spring 的注解， 而 Resource 是 java 的,两个都可以
    private Queue_Produce queue_produce;

    @Test
    void contextLoads() {
        queue_produce.produceMessage();
    }
*/
}
