package com.json.core.action;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "主页面控制器")
@RestController("主页面控制器")
@RequestMapping("main")
public class IndexControllor {

    /*@RequestMapping("index")
    public String index(){
        return "hello word!!";
    }*/
}
