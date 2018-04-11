package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary002;
import com.iflytek.cachemanager.mapper.Dictionary002Mapper;
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
public class Dictionary002Controller {

    @Autowired
    private Dictionary002Mapper dictionary002Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description:01 增加服务器组
     */
    @RequestMapping(value = "addingservergroups", method = RequestMethod.POST)
    public Result addingservergroups() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(1);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:02 删除服务器组
     */
    @RequestMapping(value = "deleteaservergroup", method = RequestMethod.POST)
    public Result deleteaservergroup() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(2);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:03 输入服务器组ID
     */
    @RequestMapping(value = "enterservergroupid", method = RequestMethod.POST)
    public Result enterservergroupid() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(3);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:04 显示服务器组名称
     */
    @RequestMapping(value = "displayservergroupname", method = RequestMethod.POST)
    public Result displayservergroupname() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(4);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:05 显示服务器IP
     */
    @RequestMapping(value = "displayserverip", method = RequestMethod.POST)
    public Result displayserverip() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(5);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:06 设置主服务器
     */
    @RequestMapping(value = "settinguptheprimaryserver", method = RequestMethod.POST)
    public Result settinguptheprimaryserver() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(6);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:07 显示服务器类别
     */
    @RequestMapping(value = "showservercategories", method = RequestMethod.POST)
    public Result showservercategories() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(7);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:08 设置服务器同步
     */
    @RequestMapping(value = "settingupserversynchronization", method = RequestMethod.POST)
    public Result settingupserversynchronization() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(8);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:09 显示同步是否成功信息
     */
    @RequestMapping(value = "showsuccessinformationforsync", method = RequestMethod.POST)
    public Result showsuccessinformationforsync() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(9);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:10 增加服务器组
     */
    @RequestMapping(value = "showserverrealtimememoryusage", method = RequestMethod.POST)
    public Result showserverrealtimememoryusage() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(10);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:11 显示服务器keys信息
     */
    @RequestMapping(value = "displayserverkeysinformation", method = RequestMethod.POST)
    public Result displayserverkeysinformation() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(11);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:12 删除服务器
     */
    @RequestMapping(value = "removeserver", method = RequestMethod.POST)
    public Result removeserver() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(12);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:13 (删除)输入服务器分组ID
     */
    @RequestMapping(value = "delenterservergroupid", method = RequestMethod.POST)
    public Result delenterservergroupid() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(13);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:14 输入服务器地址
     */
    @RequestMapping(value = "enterserveraddress", method = RequestMethod.POST)
    public Result enterserveraddress() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(14);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:15 确认新增服务器
     */
    @RequestMapping(value = "confirmnewserver", method = RequestMethod.POST)
    public Result basicOperation() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(15);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }
}
