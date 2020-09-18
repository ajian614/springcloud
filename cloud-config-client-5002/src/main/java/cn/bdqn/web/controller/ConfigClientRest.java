package cn.bdqn.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ConfigClientRest
 * @Description TODO
 * @Date 2020/9/18 15:38
 * @Created by x1c
 */

@RestController
/**
 * 把当前bean弄出了一个代理bean,当执行对应的刷新则会把整个bean重新新建一个新的实例，
 * 即会重新去获取最新的配置和类的初始化内容
 */
@RefreshScope
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private  String applicationName;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        String str = "application: " + applicationName + "\t port: " + port;
        System.out.println("********str: " + str);
        return "application: " + applicationName + "\t port: " + port;
    }
}

