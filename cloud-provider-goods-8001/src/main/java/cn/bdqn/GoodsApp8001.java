package cn.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname GoodsApp8001
 * @Description TODO
 * @Date 2020/9/3 12:03
 * @Created by x1c
 */
@SuppressWarnings("SpellCheckingInspection")
@MapperScan("cn.bdqn.mapper")
@SpringBootApplication /* 申明该应用为springboot项目 */
@EnableDiscoveryClient /* 开启服务发现 */
public class GoodsApp8001 {
    public static void main(String[] args) {
        /* 启动spring boot应用环境 */
        SpringApplication.run(GoodsApp8001.class,args);
    }
}
