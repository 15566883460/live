package com.dlyong.live.utils;

import java.util.UUID;

/**
 * @describe 生成uuid工具类
 * @author  dlyong
 */
public class UUIDUtil {

    public static String get32UUID () {

        UUID uuid = UUID.randomUUID();
        return uuid.toString().trim().replaceAll("-","");

    }

}
