package com.zlg.cms.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.utils
 * @USER: 33036
 * @DATE: 2020/11/4
 * Java对象转成json字符串的工具类
 */
public class JsonForServlet {
    public static void writeJson(ResultData resultData, ServletResponse response){
        try {
            // 将 json 字符串传入页面
            response.getWriter().println(JSON.toJSONString(resultData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
