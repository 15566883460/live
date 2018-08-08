package com.dlyong.live.common;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class RequestCommon {
    private final static Logger logger = LoggerFactory.getLogger(RequestCommon.class);

    public static String getRequestBodyContent(HttpServletRequest request) {
        logger.debug("请求了requestCommen");
        String ret = "";
        String stringRequestBody = (String) request.getAttribute("requestBodyParams");
        if (null != stringRequestBody && StringUtils.isNotEmpty(stringRequestBody)) {
            ret = stringRequestBody;
        } else {
            try {
                List<String> list = IOUtils.readLines(request.getInputStream(), "UTF-8");

                if (null != list && list.size() > 0) {
                    StringBuffer sb = new StringBuffer("");
                    for (String str : list) {
                        sb.append(str);
                    }
                    ret = sb.toString();
                }
            } catch (IOException e) {
                logger.error("读取request流出错");
            }
        }
        logger.debug("请求结果为:{}", ret);
        return ret;
    }
}
