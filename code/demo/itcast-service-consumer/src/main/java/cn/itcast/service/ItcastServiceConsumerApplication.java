package cn.itcast.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //开启熔断器*/
@SpringCloudApplication //组合注解 相当于上面三个注解
@EnableFeignClients //启动feign组件
public class ItcastServiceConsumerApplication {

	/*@Bean
	@LoadBalanced  //开启负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}*/  //因为使用了feign,所以不需要


	public static void main(String[] args) {
		SpringApplication.run(ItcastServiceConsumerApplication.class, args);
	}

}
