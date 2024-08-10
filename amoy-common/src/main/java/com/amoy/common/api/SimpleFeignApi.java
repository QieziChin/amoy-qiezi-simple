package com.amoy.common.api;

import com.amoy.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-simple")
public interface SimpleFeignApi {

    @GetMapping(value = "/qiezi/say")
    public Result hello();


    @GetMapping("/fuck/{name}")
    public Result fuck(@PathVariable("name") String name);
}
