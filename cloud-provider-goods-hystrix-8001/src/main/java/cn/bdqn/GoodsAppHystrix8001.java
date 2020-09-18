package cn.bdqn;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @Classname GoodsApp8001
 * @Description TODO
 * @Date 2020/9/3 12:03
 * @Created by x1c
 */
@EnableCircuitBreaker //开启熔断服务
@MapperScan("cn.bdqn.mapper")
@SpringBootApplication /* 申明该应用为springboot项目 */
@EnableDiscoveryClient /* 开启服务发现 */
public class GoodsAppHystrix8001 {
    public static void main(String[] args) {
        /* 启动spring boot应用环境 */
        SpringApplication.run(GoodsAppHystrix8001.class,args);
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
