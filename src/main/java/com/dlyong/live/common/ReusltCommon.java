package com.dlyong.live.common;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReusltCommon implements Serializable {

    private ConcurrentHashMap<String, Object> serviceResultInfo = new ConcurrentHashMap<String, Object>();

    public ReusltCommon() {

        serviceResultInfo.put("code", "200");
        serviceResultInfo.put("msg", "成功");
    }

    public void put(String key, Object value) {
        serviceResultInfo.put(key, value);
    }

    public ConcurrentHashMap<String, Object> getInfo() {
        return serviceResultInfo;
    }

    public Object get(String key) {
        return serviceResultInfo.get(key);
    }

    public void putAll(ReusltCommon info) {
        serviceResultInfo.putAll(info.getInfo());
    }

    public void putAll(Map<String, Object> map) {
        serviceResultInfo.putAll(map);
    }


}
