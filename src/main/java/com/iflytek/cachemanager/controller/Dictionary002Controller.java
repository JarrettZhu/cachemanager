package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary002;
import com.iflytek.cachemanager.entity.Dictionary002Example;
import com.iflytek.cachemanager.mapper.Dictionary001Mapper;
import com.iflytek.cachemanager.mapper.Dictionary002Mapper;
import com.iflytek.cachemanager.result.Result;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.*;

/**
 * @author: tishen
 * @date: 2018/4/10
 * @description:
 */
@Slf4j
@RestController
public class Dictionary002Controller {

    @Autowired
    private Dictionary002Mapper dictionary002Mapper;

    @Autowired
    private Dictionary001Mapper dictionary001Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description:01 服务器组操作(增删查)
     */
    @RequestMapping(value = "servergroupsoperation", method = RequestMethod.POST)
    public Result servergroupsoperation() throws IOException {
        Dictionary002 dictionary002 = dictionary002Mapper.selectByPrimaryKey(3);
        JsonNode jsonNode = mapper.readTree(dictionary002.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:02 删除服务器组
     */
    @RequestMapping(value = "deleteaservergroup", method = RequestMethod.POST)
    public Result deleteaservergroup(
            @RequestParam(required = true) String servergroupid
    ) throws IOException {
        Dictionary002Example example = new Dictionary002Example();
        Dictionary002Example.Criteria criteria = example.createCriteria();
        String id = "%" + servergroupid + "%";
        criteria.andContentLike(id);
        dictionary002Mapper.deleteByExample(example);
        return Result.newSuccess(null);
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

        Dictionary002Example example1 = new Dictionary002Example();
        Dictionary002Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andPidEqualTo(20);
        List<Dictionary002> list1 = dictionary002Mapper.selectByExample(example1);

        List sonList = new ArrayList();
        for (Dictionary002 d : list1) {
            Map map = mapper.readValue(d.getContent(), Map.class);
            Dictionary002Example example2 = new Dictionary002Example();
            Dictionary002Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andPidEqualTo(d.getId());
            List<Dictionary002> ll = dictionary002Mapper.selectByExample(example2);
            List ss = new ArrayList();
            log.info(ll.size() + "");
            for (Dictionary002 dd : ll) {
                Map mm = mapper.readValue(dd.getContent(), Map.class);
                ss.add(mm);
            }
            map.put("server", ss);
            sonList.add(map);
        }
        return Result.newSuccess(sonList);
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
    public Result settinguptheprimaryserver(
            @RequestParam(required = true) String serverip,
            @RequestParam(required = true) String servergroupip
    ) throws IOException {
        Dictionary002Example example1 = new Dictionary002Example();
        Dictionary002Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andContentLike("%" + servergroupip + "%").andContentLike("%" + "主服务器" + "%");
        List<Dictionary002> list1 = dictionary002Mapper.selectByExample(example1);
        for (Dictionary002 d : list1) {
            Map map = mapper.readValue(d.getContent(), Map.class);
            map.put("ismain", "从服务器");
            d.setContent(mapper.writeValueAsString(map));
            dictionary002Mapper.updateByPrimaryKey(d);
        }

        Dictionary002Example example2 = new Dictionary002Example();
        Dictionary002Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andContentLike("%" + serverip + "%");
        List<Dictionary002> list2 = dictionary002Mapper.selectByExample(example2);
        for (Dictionary002 d : list2) {
            Map map = mapper.readValue(d.getContent(), Map.class);
            map.put("ismain", "主服务器");
            d.setContent(mapper.writeValueAsString(map));
            dictionary002Mapper.updateByPrimaryKey(d);
        }
        return Result.newSuccess(null);
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
    public Result settingupserversynchronization(
            @RequestParam(required = true) String serverip,
            @RequestParam(required = true) String issync
    ) throws IOException {
        if ("0".equals(issync)) {
            Dictionary002Example example = new Dictionary002Example();
            Dictionary002Example.Criteria criteria = example.createCriteria();
            criteria.andContentLike("%" + serverip + "%");
            List<Dictionary002> list2 = dictionary002Mapper.selectByExample(example);
            for (Dictionary002 d : list2) {
                Map map = mapper.readValue(d.getContent(), Map.class);
                map.put("issync", "不同步");
                d.setContent(mapper.writeValueAsString(map));
                dictionary002Mapper.updateByPrimaryKey(d);
            }
        }

        if ("1".equals(issync)) {
            Dictionary002Example example = new Dictionary002Example();
            Dictionary002Example.Criteria criteria = example.createCriteria();
            criteria.andContentLike("%" + serverip + "%");
            List<Dictionary002> list2 = dictionary002Mapper.selectByExample(example);
            for (Dictionary002 d : list2) {
                Map map = mapper.readValue(d.getContent(), Map.class);
                map.put("issync", "同步");
                d.setContent(mapper.writeValueAsString(map));
                dictionary002Mapper.updateByPrimaryKey(d);
            }
        }

        return Result.newSuccess(null);
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
    public Result showserverrealtimememoryusage(
            @RequestParam(required = true) String servergroupid
    ) throws IOException {
        Dictionary002 dictionary002 = new Dictionary002();
        JsonNode jsonNode = mapper.readTree(dictionary002Mapper.selectByPrimaryKey(20).getContent());
        dictionary002.setPid(20);
        dictionary002.setLevel(2);
        dictionary002.setState(1);
        dictionary002.setDescmsg("集群-服务器组");

        Map map002 = new HashMap();
        map002.put("name", jsonNode.get("name"));
        map002.put("servergroupid", servergroupid);
        map002.put("daship", jsonNode.get("daship"));
        dictionary002.setContent(mapper.writeValueAsString(map002));
        dictionary002Mapper.insertSelective(dictionary002);
        return Result.newSuccess(null);
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
    public Result removeserver(
            @RequestParam(required = true) String serverip
    ) throws IOException {
        Dictionary002Example example = new Dictionary002Example();
        Dictionary002Example.Criteria criteria = example.createCriteria();
        criteria.andContentLike("%" + serverip + "%");

        dictionary002Mapper.deleteByExample(example);
        return Result.newSuccess(null);
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
    @RequestMapping(value = "serveroperation", method = RequestMethod.POST)
    public Result serveroperation(
            @RequestParam(defaultValue = "query") String method,
            @RequestParam(required = true) String servergroupid,//输入服务组名称
            @RequestParam(required = true) String proxyip,
            @RequestParam(required = true) String zkip,
            @RequestParam(required = true) String serverip,
            @RequestParam(required = true) String serverport
    ) throws IOException {

        Dictionary002Example example1 = new Dictionary002Example();
        Dictionary002Example.Criteria criteria1 = example1.createCriteria();
//        String id = "%" + servergroupid + "%";
        criteria1.andContentLike("%" + servergroupid + "%").andLevelEqualTo(2);
        int sgid = 0;//服务组表id
        String jqname = "";
        List<Dictionary002> list = dictionary002Mapper.selectByExample(example1);
        for (Dictionary002 d : list) {
            sgid = d.getId();
            JSONObject jsonObject = JSONObject.fromObject(d.getContent());
            jqname = jsonObject.getString("name");
        }

        Dictionary002 dictionary002 = new Dictionary002();
        log.info("sgid = " + sgid);
        dictionary002.setPid(sgid);
        log.info("disgid = " + dictionary002.getPid());
        dictionary002.setLevel(3);
        dictionary002.setState(1);
        dictionary002.setDescmsg("集群-服务器组-服务器");

        Map map002 = new HashMap();
        map002.put("name", jqname);
        map002.put("servergroupid", servergroupid);
        map002.put("proxyip", proxyip);
        map002.put("zkip", zkip);
        map002.put("serverip", serverip);
        map002.put("serverport", serverport);
        map002.put("ismain", "从服务器");
        map002.put("issync", "不同步");
        map002.put("jvmpath", "自定");
        map002.put("javamemory", "自定");
        dictionary002.setContent(mapper.writeValueAsString(map002));
        dictionary002Mapper.insertSelective(dictionary002);

        return Result.newSuccess(null);

    }
}
