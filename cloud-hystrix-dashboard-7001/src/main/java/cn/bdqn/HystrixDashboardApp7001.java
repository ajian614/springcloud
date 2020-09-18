package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname HystrixDashboardApp7001
 * @Description TODO
 * @Date 2020/9/14 14:33
 * @Created by x1c
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启hystrix的熔断监控服务
public class HystrixDashboardApp7001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApp7001.class,args);
    }
}
