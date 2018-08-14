package com.dlyong.live.service;

import com.dlyong.live.common.ReusltCommon;
import com.dlyong.live.model.User;

public interface UserService {

     ReusltCommon register(User user);
     ReusltCommon login(User user);
}
