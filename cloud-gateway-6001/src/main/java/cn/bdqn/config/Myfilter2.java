package cn.bdqn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname Myfilter2
 * @Description TODO
 * @Date 2020/9/17 9:08
 * @Created by x1c
 */
@Slf4j
@Component
public class Myfilter2 implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入了myfilter2自定义过滤器");
        log.info("this is a pre filter");
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("this is a post filter");
        }));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
