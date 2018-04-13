package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.*;
import com.iflytek.cachemanager.mapper.Dictionary001Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: tishen
 * @date: 2018/4/10
 * @description:
 */
@RestController
public class Dictionary001Controller {

    @Autowired
    private Dictionary001Mapper dictionary001Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Author:ZhuJunHua
     * @Description:01 获取集群信息
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewclustername", method = RequestMethod.POST)
    public Result viewclustername(
            @RequestParam(defaultValue = "query") String method,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String ip,
            @RequestParam(required = false) String port,
            @RequestParam(required = false) String zkip,
            @RequestParam(required = false) String rw,
            @RequestParam(required = false) String proxyip,
            @RequestParam(required = false) String targetip,
            @RequestParam(required = false) String jvmpath,
            @RequestParam(required = false) String totalnumberconnections,
            @RequestParam(required = false) String totalfail,
            @RequestParam(required = false) String javamemory,
            @RequestParam(required = false) String daship,
            @RequestParam(required = false) String ver,
            @RequestParam(required = false) String dashport,
            @RequestParam(required = false) String refreshtime
            ) throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(1);
        Map map = mapper.readValue(dictionary001.getContent(), Map.class);
        if ("query".equals(method)) {
            return Result.newSuccess(map);
        } else if ("update".equals(method)) {
            map.put("name", name);
            map.put("ip", ip);
            map.put("port", port);
            map.put("zkip", zkip);
            map.put("rw", rw);
            map.put("proxyip", proxyip);
            map.put("targetip", targetip);
            map.put("jvmpath", jvmpath);
            map.put("totalnumberconnections", totalnumberconnections);
            map.put("totalfail", totalfail);
            map.put("javamemory", javamemory);
            map.put("daship", daship);
            map.put("ver", ver);
            map.put("refreshtime", refreshtime);
            dictionary001.setContent(mapper.writeValueAsString(map));
            dictionary001Mapper.updateByPrimaryKey(dictionary001);
            return Result.newSuccess(map);
        }
        return Result.newFailure("method no found", null);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:02 查看分布式任务协调服务地址
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewdistributedtaskcoordinationserviceaddresses", method = RequestMethod.POST)
    public Result viewdistributedtaskcoordinationserviceaddresses() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(2);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:03 查看QPS(读写速度)数值
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewQPSvalues", method = RequestMethod.POST)
    public Result viewQPSvalues() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(3);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:04 查看Sessions(会话)连接数
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "toviewthenumberofsessionsconnections", method = RequestMethod.POST)
    public Result toviewthenumberofsessionsconnections() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(4);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:05 查看内存使用总数
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewtotalmemoryusage", method = RequestMethod.POST)
    public Result viewtotalmemoryusage() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(5);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:06 查看keys总数
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewtotalkeys", method = RequestMethod.POST)
    public Result viewtotalkeys() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(6);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:07 查看dashboard地址
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewdashboardaddress", method = RequestMethod.POST)
    public Result viewdashboardaddress() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(7);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:08 查看dashboard信息
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewdashboardinformation", method = RequestMethod.POST)
    public Result viewdashboardinformation(
            @RequestParam(defaultValue = "query")String method,
            @RequestParam(required = false)String daship,
            @RequestParam(required = false)String ver,
            @RequestParam(required = false)String dashport,
            @RequestParam(required = false)String jvmpath,
            @RequestParam(required = false)String cppath
            ) throws IOException {
        Dictionary001 dictionary001dash = dictionary001Mapper.selectByPrimaryKey(8);
        Dictionary001 dictionary001cluster = dictionary001Mapper.selectByPrimaryKey(1);
        Map mapdash = mapper.readValue(dictionary001dash.getContent(), Map.class);
        Map mapcluster = mapper.readValue(dictionary001cluster.getContent(), Map.class);
        Map mapmerge = new HashMap();
        mapmerge.putAll(mapdash);
        mapmerge.putAll(mapcluster);
        if ("query".equals(method)){
            return Result.newSuccess(mapmerge);
        }else if ("update".equals(method)){
            mapdash.put("daship",daship);
            mapdash.put("ver",ver);
            mapdash.put("dashport",dashport);
            mapdash.put("jvmpath",jvmpath);
            mapdash.put("cppath",cppath);
            dictionary001dash.setContent(mapper.writeValueAsString(mapdash));
            dictionary001Mapper.updateByPrimaryKey(dictionary001dash);
            return Result.newSuccess(mapdash);
        }
        return Result.newFailure("method no found", null);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:09 查看刷新时间
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewrefreshtime", method = RequestMethod.POST)
    public Result viewrefreshtime() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(9);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:10 设置刷新时间
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "setrefreshtime", method = RequestMethod.POST)
    public Result setrefreshtime(
            @RequestParam(required = true) int refreshtime
    ) throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(1);
        Map map = mapper.readValue(dictionary001.getContent(),Map.class);
        map.put("refreshtime", refreshtime);
        dictionary001.setContent(mapper.writeValueAsString(map));
        dictionary001Mapper.updateByPrimaryKey(dictionary001);
        return Result.newSuccess(null);
    }

    /**
     * @Author:ZhuJunHua
     * @Description:11 查看QPS(读写速度)动态图
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewQPSdynamicdiagram", method = RequestMethod.POST)
    public Result viewQPSdynamicdiagram() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(11);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
    }
}
