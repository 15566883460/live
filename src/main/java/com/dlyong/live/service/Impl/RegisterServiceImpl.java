package com.dlyong.live.service.Impl;

import com.dlyong.live.common.ResultInfo;
import com.dlyong.live.exception.DatabaseOperateException;
import com.dlyong.live.exception.ParamException;
import com.dlyong.live.mapper.UserMapper;
import com.dlyong.live.model.User;
import com.dlyong.live.service.RegisterService;
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
public class RegisterServiceImpl implements RegisterService {
    // logger
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
    // 注入userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * @param user
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultInfo register(User user ) {
        // 创建返回值
        ResultInfo resultInfo = new ResultInfo();
        // 解析参数
       //user User user = JSON.parseObject(jsonStr, User.class);
        if(StringUtils.isBlank(user.getUserName())) {
            throw new ParamException("用户姓名不能为空！");
        }
        if(StringUtils.isBlank(user.getSex())) {
            throw new ParamException("用户性别不能为空");
        }
        if(StringUtils.isBlank(user.getPhone())) {
            throw new ParamException("用户手机号不能为空！");
        }
        // user表数据做成
        user.setId(UUIDUtil.get32UUID());
        try {
            logger.debug("插入操作开始");
            userMapper.insert(user);
            logger.debug("插入操作结束");
        }catch(Exception e){
            throw new DatabaseOperateException("数据库插入数据异常");
        }

        return  resultInfo;
    }
}
