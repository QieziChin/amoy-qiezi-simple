package com.amoy.cloudflare.app;


import com.amoy.cloudflare.service.ResolveService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/ibfnfdhaQL7")
public class ResolveController {

    @Value("${cloudflare.local.secret}")
    private String secret;

    @Resource
    private ResolveService resolveService;

    @PostMapping("resolve")
    public void Resolve(@RequestHeader(value = "Authorization") String verify, HttpServletResponse response){
        if (!verify.equals(secret)){
            response.setStatus(403);
        }
        resolveService.resolve();
    }

}
