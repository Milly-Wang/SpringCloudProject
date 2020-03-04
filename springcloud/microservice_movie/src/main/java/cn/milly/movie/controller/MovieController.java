package cn.milly.movie.controller;

import cn.milly.movie.client.UserController;
import cn.milly.movie.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/movie")
@RestController
@Api(description = "电影核心Api")
public class MovieController {
    //@Autowired
    //private RestTemplate restTemplate;

    //没有使用Eureka版本
//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public String order() {
//        Integer id = 2;
//
//        //使用RestTemplate远程调用用户微服务
//        // 1.url 2.封装对象类型
//        User user = restTemplate.getForObject("http://localhost:9001/user/"+id, User.class);
//        System.out.println( user +"=====Ording now");
//        return "Order Successfully";
//    }

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    //使用Eureka版本
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order() {
//        Integer id = 2;
//
//        //到Eureka发现微服务
//        //返回值是list,获取到同名微服务
//        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user");
//        ServiceInstance serviceInstance = instances.get(0);
//        User user = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id, User.class);
//        System.out.println( user +"=====Ording now");
//        return "Order Successfully";
//    }

//    @Autowired
//    private LoadBalancerClient client;
//    //使用Ribbon负载均衡
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order() {
//        Integer id = 2;
//
//        //use ribbon to choose microservice
//        ServiceInstance serviceInstance = client.choose("microservice-user");
//
//        User user = restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id, User.class);
//        System.out.println( user +"=====Ording now");
//        return "Order Successfully";
//    }

//    //使用Ribbon负载均衡简化版
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order() {
//        Integer id = 2;
//        User user = restTemplate.getForObject("http://microservice-user/user/"+id, User.class);
//        System.out.println( user +"=====Ording now");
//        return "Order Successfully";
//    }
    //使用OpenFeign组件简化
    @Autowired
    private UserController userController;
    @ApiOperation(value = "远程方法： 根据id查询用户方法")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        Integer id = 2;
        User user = userController.findById(id);
        System.out.println( user +"=====Ording now");
        return "Order Successfully";
    }
}
