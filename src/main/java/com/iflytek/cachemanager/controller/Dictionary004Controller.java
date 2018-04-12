package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary004;
import com.iflytek.cachemanager.mapper.Dictionary004Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by zhujunhua on 2018/4/11.
 */
@RestController
public class Dictionary004Controller {
    @Autowired
    Dictionary004Mapper dictionary004Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description:01 查看Proxy代理ID
     */
    @RequestMapping(value = "viewproxyagentid", method = RequestMethod.POST)
    public Result viewproxyagentid() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(1);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:02 查看Proxy代理Token信息
     */
    @RequestMapping(value = "viewproxytokeninformation", method = RequestMethod.POST)
    public Result viewproxytokeninformation() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(2);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:03 查看Proxy代理地址
     */
    @RequestMapping(value = "toviewproxyaddresses", method = RequestMethod.POST)
    public Result toviewproxyaddresses() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(3);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:04 查看代理Admin地址
     */
    @RequestMapping(value = "viewagentadminaddress", method = RequestMethod.POST)
    public Result viewagentadminaddress() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(4);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:05 查看代理Sessions
     */
    @RequestMapping(value = "viewagentsessions", method = RequestMethod.POST)
    public Result viewagentsessions() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(5);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:06 查看代理Commands信息
     */
    @RequestMapping(value = "viewagentcommandsinformation", method = RequestMethod.POST)
    public Result viewagentcommandsinformation() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(6);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:07 输入代理Admin地址
     */
    @RequestMapping(value = "enterproxyadminaddress", method = RequestMethod.POST)
    public Result enterproxyadminaddress() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(7);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:08 添加Proxy代理地址
     */
    @RequestMapping(value = "addproxyproxyaddress", method = RequestMethod.POST)
    public Result addproxyproxyaddress() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(8);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:09 删除Proxy代理地址
     */
    @RequestMapping(value = "delproxyaddress", method = RequestMethod.POST)
    public Result delproxyaddress() throws IOException {
        Dictionary004 dictionary004 = dictionary004Mapper.selectByPrimaryKey(9);
        JsonNode jsonNode = mapper.readTree(dictionary004.getContent());
        return Result.newSuccess(jsonNode);
    }
}
