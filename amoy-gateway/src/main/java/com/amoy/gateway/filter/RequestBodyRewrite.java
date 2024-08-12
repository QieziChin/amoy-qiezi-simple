package com.amoy.gateway.filter;

import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class RequestBodyRewrite implements RewriteFunction<String, String> {
    @Override
    public Publisher<String> apply(ServerWebExchange serverWebExchange, String s) {

        try {
            //
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "未知的异常"));
        } catch (Exception e){
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "未知的异常"));
        }
    }
}
