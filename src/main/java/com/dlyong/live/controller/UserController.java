package com.dlyong.live.controller;

import com.alibaba.fastjson.JSONObject;
import com.dlyong.live.common.ReusltCommon;
import com.dlyong.live.model.User;
import com.dlyong.live.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dlyong
 * @describe 用户controller
 */
@RestController
@RequestMapping("/user")
@Api("用户接口测试")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册接口", notes = "用户注册接口", httpMethod = "POST")
    public Object register(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) User user) {

        ReusltCommon reusltCommon = userService.register(user);
        JSONObject jsonObject = new JSONObject(reusltCommon.getInfo());
        return jsonObject;
    }

    /**
     * 用户登陆接口
     */
    @RequestMapping(value = "/login")
    public Object login (@RequestBody User user) {

        ReusltCommon reusltCommon = userService.login(user);
        JSONObject jsonObject = new JSONObject(reusltCommon.getInfo());
        return jsonObject;

    }

}
