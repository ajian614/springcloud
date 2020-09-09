package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname OrderApp9001
 * @Description TODO
 * @Date 2020/9/4 9:12
 * @Created by x1c
 */

@SpringBootApplication
@EnableFeignClients(basePackages="cn.bdqn.service")
public class OrderApp9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp9001.class,args);
    }
}
