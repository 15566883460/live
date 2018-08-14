package com.dlyong.live.service.Impl;

import com.dlyong.live.common.ReusltCommon;
import com.dlyong.live.exception.DatabaseOperateException;
import com.dlyong.live.exception.ParamException;
import com.dlyong.live.mapper.UserMapper;
import com.dlyong.live.model.User;
import com.dlyong.live.service.UserService;
import com.dlyong.live.utils.MD5Util;
import com.dlyong.live.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @describe 注册实现类
 * @author   dlyong
 */
@Service
public class UserServiceImpl implements UserService {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    // 注入userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReusltCommon register(User user ) {
        // 创建返回值
        ReusltCommon reusltCommon = new ReusltCommon();
        // 解析参数
       //user User user = JSON.parseObject(jsonStr, User.class);
        if(StringUtils.isBlank(user.getUserName())) {
            throw new ParamException("用户姓名不能为空！");
        }
        if(StringUtils.isBlank(user.getPassword())) {
            throw new ParamException("用户密码不能为空");
        }
        if(StringUtils.isBlank(user.getPhone())) {
            throw new ParamException("用户手机号不能为空！");
        }
        // user表数据做成
        user.setId(UUIDUtil.get32UUID());
        user.setPassword(MD5Util.md5(user.getPassword()));
        try {
            logger.debug("插入操作开始");
            userMapper.insert(user);
            logger.debug("插入操作结束");
        }catch(Exception e){
            throw new DatabaseOperateException("数据库插入数据异常");
        }

        return  reusltCommon;
    }

    @Override
    public ReusltCommon login(User user) {
        return null;
    }

}
