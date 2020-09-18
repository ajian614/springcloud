package cn.bdqn.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname Myfilter
 * @Description TODO
 * @Date 2020/9/16 10:59
 * @Created by x1c
 */
@Component // 必须把它注册进容器，才能被gateway找到该对象
public class Myfilter implements GatewayFilter, Ordered {

    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //记录请求开始时间
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        System.out.println("进入了myfilter自定义过滤器");
        return chain.filter(exchange).then(Mono.fromRunnable(new Runnable() {
            @Override
            public void run() {
                Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                if (startTime != null) {
                    //打印
                    System.out.println(exchange.getRequest().getURI() + " 耗时" + (System.currentTimeMillis() - startTime));
                }
            }
        }));
    }

    @Override
    public int getOrder() {
        //filter执行的优先级,值越小则优先级越大
        return 0;
    }
}
