package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary004;
import com.iflytek.cachemanager.entity.Dictionary004Example;
import com.iflytek.cachemanager.mapper.Dictionary004Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * Created by zhujunhua on 2018/4/11.
 */
@RestController
public class Dictionary004Controller {
    @Autowired
    private Dictionary004Mapper dictionary004Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description:01 查看信息
     */
    @RequestMapping(value = "viewproxyagentid", method = RequestMethod.POST)
    public Result viewproxyagentid() throws IOException {
        Dictionary004Example example1 = new Dictionary004Example();
        Dictionary004Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andPidEqualTo(20);
        List<Dictionary004> list1 = dictionary004Mapper.selectByExample(example1);

        List sonList = new ArrayList();
        for (Dictionary004 d : list1) {
            Map map = mapper.readValue(d.getContent(), Map.class);
            sonList.add(map);
        }
        return Result.newSuccess(sonList);
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
    public Result addproxyproxyaddress(
            @RequestParam(required = true)String proxyip,
            @RequestParam(required = true)String adminip
    ) throws IOException {
        Dictionary004 dictionary004 = new Dictionary004();
        JsonNode jsonNode = mapper.readTree(dictionary004Mapper.selectByPrimaryKey(20).getContent());
        dictionary004.setPid(20);
        dictionary004.setLevel(2);
        dictionary004.setState(1);
        dictionary004.setDescmsg("集群-代理服务器");

        int random = 0;
        for(int j = 0; j< 100; j++){
            random = (int)((Math.random()*9+1)*100000);
        }
        Map map = new HashMap();
        map.put("name", jsonNode.get("name"));
        map.put("proxyip", proxyip);
        map.put("zkip", jsonNode.get("zkip"));
        map.put("adminip", adminip);
        map.put("proxyid", random);
        map.put("tokenmsg", UUID.randomUUID().toString().replaceAll("\\-", ""));
        map.put("jvmpath", "jvm运行环境");
        map.put("javamemory", "java内存");
        map.put("Numberconnections","并发连接数");
        map.put("RWoperands","读写操作数");

        dictionary004.setContent(mapper.writeValueAsString(map));
        dictionary004Mapper.insertSelective(dictionary004);
        return Result.newSuccess(null);
    }

    /**
     * @Description:09 删除Proxy代理地址
     */
    @RequestMapping(value = "delproxyaddress", method = RequestMethod.POST)
    public Result delproxyaddress(
            @RequestParam(required = true)String proxyid
    ) throws IOException {
        Dictionary004Example example = new Dictionary004Example();
        Dictionary004Example.Criteria criteria = example.createCriteria();
        criteria.andContentLike("%" + proxyid + "%");

        dictionary004Mapper.deleteByExample(example);
        return Result.newSuccess(null);
    }
}
