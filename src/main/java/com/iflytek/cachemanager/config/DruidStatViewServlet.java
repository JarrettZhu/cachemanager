package com.iflytek.cachemanager.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author: tishen
 * @date: 2018/4/10
 * @description:
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                // IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name = "allow", value = ""),
                // IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name = "deny", value = ""),
                // 用户名
                @WebInitParam(name = "loginUsername", value = "root"),
                // 密码
                @WebInitParam(name = "loginPassword", value = "root"),
                // 禁用HTML页面上的“Reset All”功能
                @WebInitParam(name = "resetEnable", value = "false")
        })
public class DruidStatViewServlet extends StatViewServlet {

    private static final long serialVersionUID = -2688872071445249539L;

}
