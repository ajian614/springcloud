package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @Classname GatewayApp6001
 * @Description TODO
 * @Date 2020/9/14 17:25
 * @Created by x1c
 */
@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现，便于服务的调用
public class GatewayApp6001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp6001.class, args);
    }
}
