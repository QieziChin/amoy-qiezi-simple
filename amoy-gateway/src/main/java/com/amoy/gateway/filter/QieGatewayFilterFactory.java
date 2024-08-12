package com.amoy.gateway.filter;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@Component
public class QieGatewayFilterFactory extends AbstractGatewayFilterFactory<QieGatewayFilterFactory.Config> {



    public static class Config{
        private String template;
        public String getTemplate(){return template;}
        public void setTemplate(String template) {this.template = template;}
    }

    @Override
    public GatewayFilter apply(QieGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (exchange.getResponse().getStatusCode() == HttpStatus.NOT_FOUND) {
                    JSONObject result = new JSONObject();
                    result.put("timestamp", new Date());
                    result.put("status", HttpStatus.NOT_FOUND.value());
                    result.put("message", HttpStatus.NOT_FOUND.getReasonPhrase());
                    result.put("data", null);

                    byte[] bytes = new byte[0];
                    try {
                        bytes = result.toString().getBytes();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);

                    exchange.getResponse().writeWith(Flux.just(buffer));
                    exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                    exchange.getResponse().writeAndFlushWith(Flux.just(buffer).windowUntilChanged());
                    return exchange.getResponse().setComplete();
                } else {
                    return chain.filter(exchange);
                }
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return super.shortcutFieldOrder();
    }
}
