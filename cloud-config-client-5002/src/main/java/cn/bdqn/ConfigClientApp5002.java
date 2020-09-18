package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname ConfigClientApp5002
 * @Description TODO
 * @Date 2020/9/18 15:36
 * @Created by x1c
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApp5002 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp5002.class,args);
    }
}
