package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.*;
import com.iflytek.cachemanager.mapper.Dictionary001Mapper;
import com.iflytek.cachemanager.mapper.Dictionary002Mapper;
import com.iflytek.cachemanager.mapper.Dictionary003Mapper;
import com.iflytek.cachemanager.mapper.slotsobjectMapper;
import com.iflytek.cachemanager.result.Result;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private Dictionary003Mapper dictionary003Mapper;

    @Autowired
    private Dictionary002Mapper dictionary002Mapper;

    @Autowired
    private Dictionary001Mapper dictionary001Mapper;

    @Autowired
    private slotsobjectMapper slotsobjectMapper;

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
        //删除服务组同时删除其下的服务器和slot组，然后把占用的slot释放出来
        String id = "%" + servergroupid + "%";
        Dictionary002Example example = new Dictionary002Example();
        Dictionary002Example.Criteria criteria = example.createCriteria();
        criteria.andContentLike(id);
        dictionary002Mapper.deleteByExample(example);

        Dictionary003Example example1 = new Dictionary003Example();
        Dictionary003Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andContentLike(id);
        dictionary003Mapper.deleteByExample(example1);

        slotsobjectExample example3 = new slotsobjectExample();
        slotsobjectExample.Criteria criteria2 = example3.createCriteria();
        criteria2.andContentLike(id);
        List<slotsobject> list = slotsobjectMapper.selectByExample(example3);
        for (slotsobject d : list) {
            //pid置为空
            d.setPid(null);
            d.setLevel(3);

            Map map = mapper.readValue(d.getContent(), Map.class);
            map.put("group_id", "");
            d.setContent(mapper.writeValueAsString(map));
            slotsobjectMapper.updateByPrimaryKey(d);
        }
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

        log.info("服务器组长度为：" + list1.size());
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

        //先查出父节点服务器组的相关信息
        Dictionary002Example example1 = new Dictionary002Example();
        Dictionary002Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andContentLike("%" + servergroupid + "%").andLevelEqualTo(2);
        int sgid = 0;//服务组表id
        String jqname = "";//集群名称
        List<Dictionary002> list1 = dictionary002Mapper.selectByExample(example1);
        for (Dictionary002 d : list1) {
            sgid = d.getId();
            JSONObject jsonObject = JSONObject.fromObject(d.getContent());
            jqname = jsonObject.getString("name");
        }

        String jvmpath = "JVM version is 25.92-b14";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MinHeapFreeRatio=0;");
        stringBuffer.append("MaxHeapFreeRatio= 100;");
        stringBuffer.append("MaxHeapSize= 734003200 (700.0MB);");
        stringBuffer.append("NewSize= 44040192 (42.0MB);");
        stringBuffer.append("MaxNewSize= 244318208 (233.0MB);");
        stringBuffer.append("OldSize= 88080384 (84.0MB);");
        stringBuffer.append("NewRatio= 2;");
        stringBuffer.append("SurvivorRatio= 8;");
        stringBuffer.append("MetaspaceSize= 21807104 (20.796875MB);");
        stringBuffer.append("CompressedClassSpaceSize= 1073741824 (1024.0MB);");
        stringBuffer.append("MaxMetaspaceSize= 17592186044415 MB;");
        stringBuffer.append("G1HeapRegionSize= 0 (0.0MB);");

        Dictionary002Example example2 = new Dictionary002Example();
        Dictionary002Example.Criteria criteria2 = example2.createCriteria();
//        criteria2.andContentLike("%" + "集群-服务器组" + "%").andLevelEqualTo(2);
        criteria2.andPidEqualTo(20);
        List<Dictionary002> list2 = dictionary002Mapper.selectByExample(example2);
        log.info("是否为第一个服务器组，服务器组list长度：" + list2.size());
        //判断是否为第一个服务器组
        if (list2.size() == 1) {
            log.info("是第一个服务器组！！！");

            Dictionary002Example exampleserver = new Dictionary002Example();
            Dictionary002Example.Criteria criteriaserver = exampleserver.createCriteria();
//            criteriaserver.andDescmsgEqualTo("%" + "集群-服务器组-服务器" + "%").andLevelEqualTo(3);
//            criteriaserver.andPidEqualTo(20);
              criteriaserver.andLevelEqualTo(3);

            List<Dictionary002> listserver = dictionary002Mapper.selectByExample(exampleserver);
            log.info("是否为第一个服务器，服务器list长度：" + listserver.size());
            //判断是否为第一个服务器
            if (listserver.size() == 0){
                log.info("是第一个服务器！！！");
                //添加服务器
                Dictionary002 dictionary002 = new Dictionary002();
                dictionary002.setPid(sgid);//服务器pid等于父节点服务器组id
                dictionary002.setLevel(3);
                dictionary002.setState(1);
                dictionary002.setDescmsg("集群-服务器组-服务器");

                Map map002 = new HashMap();
                map002.put("name", jqname);
                map002.put("servergroupid", servergroupid);
                map002.put("proxyip", proxyip);
                map002.put("zkip", zkip);
                map002.put("serverstatus", "运行正常");
                map002.put("serverip", serverip);
                map002.put("serverport", serverport);
                map002.put("ismain", "从服务器");
                map002.put("issync", "不同步");
                map002.put("jvmpath", jvmpath);
                map002.put("javamemory", stringBuffer);
                dictionary002.setContent(mapper.writeValueAsString(map002));
                dictionary002Mapper.insertSelective(dictionary002);

                //添加服务器的同时添加slots组
                Dictionary003 dictionary003 = new Dictionary003();
                dictionary003.setPid(sgid);
                dictionary003.setLevel(2);
                dictionary003.setState(1);
                dictionary003.setDescmsg("集群-服务器组-Slot组");

                Map map003 = new HashMap();
                map003.put("name", jqname);
                map003.put("servergroupid", servergroupid);
                map003.put("zkip", zkip);
                map003.put("serverip", serverip);
                map003.put("serverport", serverport);
                map003.put("slotgroupid", "Slotgroup");
                dictionary003.setContent(mapper.writeValueAsString(map003));
                dictionary003Mapper.insertSelective(dictionary003);

                //分配slot
//                slotsobjectExample example = new slotsobjectExample();
//                List<slotsobject> list = slotsobjectMapper.selectByExample(example);
//                for (slotsobject d2 : list) {
//                    d2.setPid(sgid);
//
//                    Map map = mapper.readValue(d2.getContent(), Map.class);
//                    map.put("group_id", servergroupid);
//                    d2.setContent(mapper.writeValueAsString(map));
//                    slotsobjectMapper.updateByPrimaryKey(d2);
//                    log.info("分配slot给组" + servergroupid + "成功");
//                }
                return Result.newSuccess(null);
            }
        }

        //若不是第一个服务器组
        Dictionary002 dictionary002new = new Dictionary002();
        dictionary002new.setPid(sgid);//服务器pid等于父节点服务器组id
        dictionary002new.setLevel(3);
        dictionary002new.setState(1);
        dictionary002new.setDescmsg("集群-服务器组-服务器");

        Map map002new = new HashMap();
        map002new.put("name", jqname);
        map002new.put("servergroupid", servergroupid);
        map002new.put("proxyip", proxyip);
        map002new.put("zkip", zkip);
        map002new.put("serverstatus", "运行正常");
        map002new.put("serverip", serverip);
        map002new.put("serverport", serverport);
        map002new.put("ismain", "从服务器");
        map002new.put("issync", "不同步");
        map002new.put("jvmpath", jvmpath);
        map002new.put("javamemory", stringBuffer);
        dictionary002new.setContent(mapper.writeValueAsString(map002new));
        dictionary002Mapper.insertSelective(dictionary002new);


        Dictionary003Example exampleslot = new Dictionary003Example();
        Dictionary003Example.Criteria criteriaserver = exampleslot.createCriteria();
//            criteriaserver.andDescmsgEqualTo("%" + "集群-服务器组-服务器" + "%").andLevelEqualTo(3);
//            criteriaserver.andPidEqualTo(20);
        criteriaserver.andLevelEqualTo(2);

        Map map = new HashMap();
        int i = 0;
        boolean ret;
        List<Dictionary003> listslot = dictionary003Mapper.selectByExample(exampleslot);
        log.info("是否为该服务器组的第一个slot组");
        for (Dictionary003 b : listslot) {
            map.put("pid"+i, b.getPid());
            i++;
        }
        ret = map.containsValue(sgid);
        log.info("sgid = "+sgid);
        log.info("i = "+i);
        log.info(ret?"true":"false");
        if (!ret){
            //添加服务器的同时添加slots组
            Dictionary003 dictionary003 = new Dictionary003();
            dictionary003.setPid(sgid);
            dictionary003.setLevel(2);
            dictionary003.setState(1);
            dictionary003.setDescmsg("集群-服务器组-Slot组");

            Map map003 = new HashMap();
            map003.put("name", jqname);
            map003.put("servergroupid", servergroupid);
            map003.put("zkip", zkip);
            map003.put("serverip", serverip);
            map003.put("serverport", serverport);
            map003.put("slotgroupid", "Slot分组ID（自定）");
            dictionary003.setContent(mapper.writeValueAsString(map003));
            dictionary003Mapper.insertSelective(dictionary003);
        }
        return Result.newSuccess(null);
    }



    /**
     * @Description:16 查询服务器组的主服务器
     */
    @RequestMapping(value = "querymainserver", method = RequestMethod.POST)
    public Result enterserveraddress(
            @RequestParam(required = true)String servergroupid
    ) throws IOException {
        Dictionary002Example example = new Dictionary002Example();
        Dictionary002Example.Criteria criteria = example.createCriteria();
        criteria.andContentLike("%" + servergroupid + "%").andContentLike("%主服务器%");

        Map map1 = new HashMap();
        List<Dictionary002> list = dictionary002Mapper.selectByExample(example);
        for (Dictionary002 d :list){
            Map map = mapper.readValue(d.getContent(),Map.class);

            map1.put("MainServerIp", map.get("serverip"));
            map1.put("MainServerPort", map.get("serverport"));
        }

        return Result.newSuccess(map1);
    }
}
