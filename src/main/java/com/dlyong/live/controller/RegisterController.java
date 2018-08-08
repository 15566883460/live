package com.dlyong.live.controller;

import com.alibaba.fastjson.JSONObject;
import com.dlyong.live.common.RequestCommon;
import com.dlyong.live.common.ResultInfo;
import com.dlyong.live.model.User;
import com.dlyong.live.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe 用户注册controller
 * @author  dlyong
 */
@RestController
@RequestMapping("/registerController")
@Api("用户接口测试")
public class RegisterController {

   @Autowired
   private RegisterService registerService;

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ApiOperation(value="用户注册接口",notes="用户注册接口" ,httpMethod = "POST")
    public Object register (@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){


        // 获取前台传过来的参数
        //String jsonStr = RequestCommon.getRequestBodyContent(request);
        ResultInfo resultInfo = registerService.register(user);
        JSONObject jsonObject = new JSONObject(resultInfo.getInfo());
        return  jsonObject;
    }
}
