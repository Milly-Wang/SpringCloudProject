package cn.milly.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//配置中心服务端
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
