package com.dlyong.live.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chendai on 2018/3/19.
 */
@RestController
@Api("swaggerTestController相关api")
public class TestController {

    public String index () {
        return "success";
    }
}