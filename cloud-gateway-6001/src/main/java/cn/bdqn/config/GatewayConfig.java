package cn.bdqn.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.*;
import java.util.function.Function;

/**
 * @Classname GatewayConfig
 * @Description TODO
 * @Date 2020/9/16 8:50
 * @Created by x1c
 */
@Configuration // 配置类
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("path_route1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).route("path_route2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("path_route3",
                r -> r.path("/mil")
                        .uri("http://news.baidu.com/mil")).build();
    }

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().
                route(new Function<PredicateSpec, Route.AsyncBuilder>() {
                    @Override
                    public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                        return predicateSpec
                                .path("/test")
                                .filters(new Function<GatewayFilterSpec, UriSpec>() {
                                    @Override
                                    public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
                                        return gatewayFilterSpec.stripPrefix(1).filter(new Myfilter());
                                    }
                                })
                                .uri("lb://cloud-provider-goods")
                                .id("xxxxx)");

                    }
                }).build();
    }


    public static void main(String[] args) {
        // 获取当前的 ZonedDateTime 通过系统默认时区
        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println("当前 ZonedDateTime:" + zdt1);
        LocalDateTime ldt2 = zdt1.toLocalDateTime();
        OffsetDateTime odt = zdt1.toOffsetDateTime();
        Instant i1 = zdt1.toInstant();
        System.out.println("转为LocalDateTime: " + ldt2);
        System.out.println("转为OffsetDateTime: " + odt);
        System.out.println("转为Instant: " + i1);
    }
}
