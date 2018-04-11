package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary001;
import com.iflytek.cachemanager.mapper.Dictionary001Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
     * @Description:01 查看集群名称
     * @Date:下午8:19 2018/4/10
     */
    @RequestMapping(value = "viewclustername", method = RequestMethod.POST)
    public Result basicOperation() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(1);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
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
    public Result viewdashboardinformation() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(8);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
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
    public Result setrefreshtime() throws IOException {
        Dictionary001 dictionary001 = dictionary001Mapper.selectByPrimaryKey(10);
        JsonNode jsonNode = mapper.readTree(dictionary001.getContent());
        return Result.newSuccess(jsonNode);
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
