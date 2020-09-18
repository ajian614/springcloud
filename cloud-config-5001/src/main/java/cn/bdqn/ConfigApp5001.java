package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname ConfigApp5001
 * @Description TODO
 * @Date 2020/9/18 14:46
 * @Created by x1c
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp5001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApp5001.class,args);
    }
}
