package com.amoy.qiezi.app;

import com.amoy.common.utils.Result;
import com.amoy.qiezi.entity.Language;
import com.amoy.qiezi.service.LanguageService;
import com.amoy.qiezi.service.RobotService;
import com.amoy.qiezi.service.VideoService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Resource
    @Qualifier("vulva")
    VideoService csv;

    @Resource
    @Qualifier("downloadTask")
    RobotService download;

    @Resource
    LanguageService language;

    @Resource
    @Qualifier("translateTask")
    RobotService translate;

    @GetMapping("import")
    public Result meili(HttpServletResponse response){
        try{
            return csv.cervix();
        } catch (Exception e) {
            response.setStatus(400);
            return Result.error(400, e.getMessage());
        }
    }

    @GetMapping("extend/translate/{thread}")
    public Result translate(@PathVariable("thread") Integer thread) {
        return translate.test(thread);
    }

    @GetMapping("extend/test/{lang}/{thread}")
    public void translate(@PathVariable("lang") String lang, @PathVariable("thread") Integer thread) {
        translate.extend(lang, thread);
    }

    @PostMapping("lang/add")
    public void langSet(@RequestBody Language lang) {
        language.add(lang);
    }
}
