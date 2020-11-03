package com.zlg.boot.activemq;

import org.springframework.boot.SpringApplication;

/**
 * @PROJECT_NAME: SpringBoot_ActiveMQ_Topic
 * @PACKAGE_NAME: com.zlg.boot.activemq
 * @USER: 33036
 * @DATE: 2020/11/2
 * 测试主题是否成功的副启动类，因为不能有两个 SpringBootApplication 注解，所以启动一个要先将另一个注释了，第一个启动成功在启动另一个
 *      不要忘了修改 yml 中的web端口
 */
//@SpringBootApplication
public class Test5566 {
    public static void main(String[] args) {
        SpringApplication.run(Test5566.class, args);
    }
}
