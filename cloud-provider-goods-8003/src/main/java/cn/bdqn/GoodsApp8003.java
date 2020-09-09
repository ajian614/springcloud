package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname GoodsApp8001
 * @Description TODO
 * @Date 2020/9/3 12:03
 * @Created by x1c
 */

@SpringBootApplication /* 申明该应用为springboot项目 */
@EnableDiscoveryClient /* 开启服务发现 */
public class GoodsApp8003 {
    public static void main(String[] args) {
        /* 启动spring boot应用环境 */
        SpringApplication.run(GoodsApp8003.class,args);
    }
}
