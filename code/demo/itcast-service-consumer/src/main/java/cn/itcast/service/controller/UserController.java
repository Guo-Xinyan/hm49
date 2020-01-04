package cn.itcast.service.controller;

import cn.itcast.service.pojo.User;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallBackMethod") // 指定一个类的全局熔断方法
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
   // @Autowired
    //private DiscoveryClient discoveryClient; // eureka客户端，可以获取到eureka中服务的信息
    @GetMapping
    @ResponseBody
    @HystrixCommand //(fallbackMethod = "queryUserByIdFallBack")
    public String queryUserById(@RequestParam("id") Long id){
        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
        //List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // 因为只有一个Service-provider。所以获取第一个实例
        //ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
        //String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        String baseUrl = "http://service-provider/user/" + id;
        String user = this.restTemplate.getForObject(baseUrl, String.class);
        return user;
    }

    /**
     * 熔断方法
     * 返回值要和被熔断的方法的返回值一致
     * 熔断方法不需要参数
     * @return
     */
    public String fallBackMethod(){
        return "请求繁忙，请您稍后再试！";
    }

}
