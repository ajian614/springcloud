package cn.bdqn.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname RestTemplateConfig
 * @Description TODO
 * @Date 2020/9/4 9:46
 * @Created by x1c
 */
@Configuration  /* 标注当前类是一个配置类 */
public class RestTemplateConfig {

    @Bean
    /*  开启Ribbon的负载均衡，简而言之，就是说它会截取RestTemplate的请求，
    然后给这个请求通过服务名进行解析，解析成对应获取到的 有效服务器的服务Host和port  */
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    // 把默认的轮询算法替换成随机算法做负载均衡
    @Bean
    public IRule customIrule(){
        return new RandomRule();
    }
}
