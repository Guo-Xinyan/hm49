package cn.itcast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * springboot应用的入口
 * @EnableAutoConfiguration //启用自动配置
 @Component //类似于<context:component-scan base-pack="">
 */

@SpringBootApplication //使用组合注解，相当于@EnableAutoConfiguration、@Component、@SpringBootConfiguration
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
