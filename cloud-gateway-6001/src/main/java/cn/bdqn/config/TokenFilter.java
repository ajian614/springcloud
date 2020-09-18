package cn.bdqn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname TokenFilter
 * @Description TODO
 * @Date 2020/9/17 9:40
 * @Created by x1c
 */

@Component
@Slf4j
public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入了TokenFilter2自定义过滤器");
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            log.info( "token is empty..." );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete(); // 完成响应
        }
        log.info( "token is not empty..." );
        return chain.filter(exchange); // 放行请求，继续链路到下一个过滤器，最终至目标微服接口服务
    }

    @Override
    public int getOrder() {
        return -100; // order 的数值越小pre越先执行，post越后执行
    }
}
