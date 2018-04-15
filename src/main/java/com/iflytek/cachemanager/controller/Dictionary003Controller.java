package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.*;
import com.iflytek.cachemanager.mapper.Dictionary003Mapper;
import com.iflytek.cachemanager.mapper.slotsobjectMapper;
import com.iflytek.cachemanager.result.Result;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhujunhua
 * @date: 2018/4/10
 * @description:
 */
@Slf4j
@RestController
public class Dictionary003Controller {
    @Autowired
    private Dictionary003Mapper dictionary003Mapper;

    @Autowired
    private slotsobjectMapper slotsobjectMapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description:01 显示Slots各分组数据大小
     */
    @RequestMapping(value = "displayslotsgroupeddatasizes", method = RequestMethod.POST)
    public Result displayslotsgroupeddatasizes() throws IOException {
        Dictionary003Example example1 = new Dictionary003Example();
        Dictionary003Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andLevelEqualTo(2);
        List<Dictionary003> list1 = dictionary003Mapper.selectByExample(example1);

        List sonlist = new ArrayList();
        for (Dictionary003 d : list1) {
            Map map = mapper.readValue(d.getContent(), Map.class);
            sonlist.add(map);
        }

        Map map = new HashMap();

        slotsobjectExample example2 = new slotsobjectExample();
        List<slotsobject> ll = slotsobjectMapper.selectByExample(example2);

        List ss = new ArrayList();
        for (slotsobject dd : ll) {
            Map mm = mapper.readValue(dd.getContent(), Map.class);
            ss.add(mm);
        }

        Dictionary003 dictionary00302 = dictionary003Mapper.selectByPrimaryKey(70);
        Map map2 = mapper.readValue(dictionary00302.getContent(),Map.class);

        Dictionary003 dictionary00303 = dictionary003Mapper.selectByPrimaryKey(20);
        Map map3 = mapper.readValue(dictionary00303.getContent(),Map.class);

        map.put("迁移开关",map2.get("disable"));
        map.put("迁移间隔",map3.get("interval"));
        map.put("slot组",sonlist);
        map.put("slots", ss);
//        sonlist.add(map);
        return Result.newSuccess(map);
    }

    /**
     * @Description:02 显示Slots各分组数据分布图
     */
    @RequestMapping(value = "displayslotsgroupeddatadistributionmap", method = RequestMethod.POST)
    public Result displayslotsgroupeddatadistributionmap() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(2);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:03 显示Slots各分组状态
     */
    @RequestMapping(value = "showslotsgroupstatus", method = RequestMethod.POST)
    public Result showslotsgroupstatus() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(3);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:04 输入Slot ID
     */
    @RequestMapping(value = "enterslotid", method = RequestMethod.POST)
    public Result enterslotid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(4);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:05 输入Group ID
     */
    @RequestMapping(value = "entergroupid", method = RequestMethod.POST)
    public Result entergroupid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(5);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:06 确认Migrate数据块
     */
    @RequestMapping(value = "confirmmigratedatablock", method = RequestMethod.POST)
    public Result confirmmigratedatablock(
            @RequestParam(required = true) String slotbeginid,
            @RequestParam(required = true) String slotendid,
            @RequestParam(required = true) String targetgroupid
    ) throws IOException {
            //先查出目标组的pid
            Dictionary003Example example1 = new Dictionary003Example();
            Dictionary003Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andContentLike("%" + targetgroupid + "%");
            int pid = 0;//服务组表id
            String groupid = "";
            List<Dictionary003> list1 = dictionary003Mapper.selectByExample(example1);
            for (Dictionary003 d : list1) {
                pid = d.getPid();

                JSONObject jsonObject = JSONObject.fromObject(d.getContent());
                groupid = jsonObject.getString("servergroupid");
            }
            log.info("pid = " + pid);
            log.info("servergroupid = " + groupid);


//        if ("normal".equals(disable)) {

            //先检查disable开关
            Dictionary003Example example = new Dictionary003Example();
            Dictionary003Example.Criteria criteria = example.createCriteria();
            criteria.andDescmsgEqualTo("迁移开关");
            List<Dictionary003> list = dictionary003Mapper.selectByExample(example);


            for (Dictionary003 dd : list) {
                Map map = mapper.readValue(dd.getContent(), Map.class);
                log.info("disable为:" + map.get("disable"));
                if ("关".equals(map.get("disable"))) {
                    //迁移过程，先更改action为等待状态（添加对象），然后更改为迁移状态，最后改为完成状态
                    slotsobjectExample example2 = new slotsobjectExample();
                    slotsobjectExample.Criteria criteria2 = example2.createCriteria();
                    criteria2.andDescmsgBetween(Integer.valueOf(slotbeginid), Integer.valueOf(slotendid));
                    List<slotsobject> list2 = slotsobjectMapper.selectByExample(example2);

                    int index = 0;
                    for (slotsobject d : list2) {

                        slotsobject slotsobject = new slotsobject();
                        slotsobject.setId(d.getId());
                        slotsobject.setPid(d.getPid());
                        slotsobject.setDescmsg(d.getDescmsg());
                        slotsobject.setLevel(3);
                        slotsobject.setState(1);

                        Map map11 = new HashMap();
                        Map map1 = mapper.readValue(d.getContent(), Map.class);

                        map11.put("index", index + "");
                        map11.put("state", "pending");
                        map11.put("target_id", targetgroupid);

                        map1.put("action", map11);
                        slotsobject.setContent(mapper.writeValueAsString(map1));
                        slotsobjectMapper.updateByPrimaryKey(slotsobject);
                        index++;
                    }

                    return Result.newSuccess("迁移开关为关闭状态，暂不进行迁移");
                }else if ("开".equals(map.get("disable"))){
                    //迁移过程，先更改action为等待状态（添加对象），然后更改为迁移状态，最后改为完成状态
                    slotsobjectExample example2 = new slotsobjectExample();
                    slotsobjectExample.Criteria criteria2 = example2.createCriteria();
                    criteria2.andDescmsgBetween(Integer.valueOf(slotbeginid), Integer.valueOf(slotendid));
                    List<slotsobject> list2 = slotsobjectMapper.selectByExample(example2);

                    int index = 0;
                    for (slotsobject d : list2) {

                        slotsobject slotsobject = new slotsobject();
                        slotsobject.setId(d.getId());
                        slotsobject.setPid(d.getPid());
                        slotsobject.setDescmsg(d.getDescmsg());
                        slotsobject.setLevel(3);
                        slotsobject.setState(1);

                        Map map11 = new HashMap();
                        Map map1 = mapper.readValue(d.getContent(), Map.class);

                        map11.put("index", index + "");
                        map11.put("state", "pending");
                        map11.put("target_id", targetgroupid);

                        map1.put("action", map11);
                        slotsobject.setContent(mapper.writeValueAsString(map1));
                        slotsobjectMapper.updateByPrimaryKey(slotsobject);
                        index++;
                    }
//
//                    saocaozuo(slotbeginid, slotendid, targetgroupid, "migrating");
//                    saocaozuo(slotbeginid, slotendid, targetgroupid, "finished");
//
//
//
//                    //迁移完毕，更新为目标组的pid，greoup_id，移除action对象
//                    slotsobjectExample example3 = new slotsobjectExample();
//                    slotsobjectExample.Criteria criteria3 = example3.createCriteria();
//                    criteria3.andDescmsgBetween(Integer.valueOf(slotbeginid), Integer.valueOf(slotendid));
//                    List<slotsobject> list3 = slotsobjectMapper.selectByExample(example3);
//                    for (slotsobject d : list3) {
//                        slotsobject slotsobject = new slotsobject();
//                        slotsobject.setId(d.getId());
//                        slotsobject.setPid(pid);
//                        slotsobject.setLevel(3);
//                        slotsobject.setState(1);
//                        slotsobject.setDescmsg(d.getDescmsg());
//
//                        Map map003 = mapper.readValue(d.getContent(), Map.class);
//                        map003.put("group_id", groupid);
//                        map003.put("action", "");
//                        map003.put("id", d.getDescmsg());
//                        slotsobject.setContent(mapper.writeValueAsString(map003));
//                        slotsobjectMapper.updateByPrimaryKey(slotsobject);
//                    }
                    disableon();
                    return Result.newSuccess(null);
                }
            }

        return Result.newSuccess("");








//            //迁移过程，先更改action为等待状态（添加对象），然后更改为迁移状态，最后改为完成状态
//            slotsobjectExample example2 = new slotsobjectExample();
//            slotsobjectExample.Criteria criteria2 = example2.createCriteria();
//            criteria2.andDescmsgBetween(Integer.valueOf(slotbeginid), Integer.valueOf(slotendid));
//            List<slotsobject> list2 = slotsobjectMapper.selectByExample(example2);
//
//            int index = 0;
//            for (slotsobject d : list2) {
//
//                slotsobject slotsobject = new slotsobject();
//                slotsobject.setId(d.getId());
//                slotsobject.setPid(d.getPid());
//                slotsobject.setDescmsg(d.getDescmsg());
//                slotsobject.setLevel(3);
//                slotsobject.setState(1);
//
//                Map map = new HashMap();
//                Map map1 = mapper.readValue(d.getContent(), Map.class);
//
//                map.put("index", index + "");
//                map.put("state", "pending");
//                map.put("target_id", targetgroupid);
//
//                map1.put("action", map);
////                map1.put("delete", "是");
//                slotsobject.setContent(mapper.writeValueAsString(map1));
//                slotsobjectMapper.updateByPrimaryKey(slotsobject);
//
////            slotsobjectExample example = new slotsobjectExample();
////            slotsobjectExample.Criteria criteria = example.createCriteria();
////            criteria.andContentLike("是");
////            slotsobjectMapper.updateByExampleSelective(slotsobject, example);
//
//                index++;
//            }
//
//
//            //先检查disable开关
//            Dictionary003Example example = new Dictionary003Example();
//            Dictionary003Example.Criteria criteria = example.createCriteria();
//            criteria.andDescmsgEqualTo("迁移开关");
//            List<Dictionary003> list = dictionary003Mapper.selectByExample(example);
//
//            for (Dictionary003 dd : list) {
//                Map map = mapper.readValue(dd.getContent(), Map.class);
//                log.info("disable为:" + map.get("disable"));
//                if ("关".equals(map.get("disable"))) {
//                    return Result.newSuccess("迁移开关为关闭状态，暂不进行迁移");
//                }
//            }
//
//            saocaozuo(slotbeginid, slotendid, targetgroupid, "migrating");
//            saocaozuo(slotbeginid, slotendid, targetgroupid, "finished");

//        }else if ("unnormal".equals(disable)){
//            //先检查disable开关
//            Dictionary003Example example = new Dictionary003Example();
//            Dictionary003Example.Criteria criteria = example.createCriteria();
//            criteria.andDescmsgEqualTo("迁移开关");
//            List<Dictionary003> list = dictionary003Mapper.selectByExample(example);
//
//            for (Dictionary003 dd : list) {
//                Map map = mapper.readValue(dd.getContent(), Map.class);
//                log.info("disable为:" + map.get("disable"));
//                if ("关".equals(map.get("disable"))) {
//                    return Result.newSuccess("迁移开关为关闭状态，暂不进行迁移");
//                }
//            }
//
//            saocaozuo(slotbeginid, slotendid, targetgroupid, "migrating");
//            saocaozuo(slotbeginid, slotendid, targetgroupid, "finished");










//        }
//        //迁移完毕，更新为目标组的pid，greoup_id，移除action对象
//        slotsobjectExample example3 = new slotsobjectExample();
//        slotsobjectExample.Criteria criteria3 = example3.createCriteria();
//        criteria3.andDescmsgBetween(Integer.valueOf(slotbeginid), Integer.valueOf(slotendid));
//        List<slotsobject> list3 = slotsobjectMapper.selectByExample(example3);
//        for (slotsobject d : list3) {
//            slotsobject slotsobject = new slotsobject();
//            slotsobject.setId(d.getId());
//            slotsobject.setPid(pid);
//            slotsobject.setLevel(3);
//            slotsobject.setState(1);
//            slotsobject.setDescmsg(d.getDescmsg());
//
//            Map map = mapper.readValue(d.getContent(), Map.class);
//            map.put("group_id", groupid);
//            map.put("action", "");
//            slotsobject.setContent(mapper.writeValueAsString(map));
//            slotsobjectMapper.updateByPrimaryKey(slotsobject);
//        }
//        return Result.newSuccess(null);
    }

    /**
     * @Description:07 输入Slot开始ID
     */
    @RequestMapping(value = "enterslotstartid", method = RequestMethod.POST)
    public Result enterslotstartid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(7);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:08 测试用添加数据 todo
     */
    @RequestMapping(value = "enterslotendid", method = RequestMethod.POST)
    public Result enterslotendid(
            @RequestParam(defaultValue = "clean") String method,
            @RequestParam(required = true) int num
    ) throws IOException {
        slotsobject slotsobject = new slotsobject();
        int i = 0;
        if ("add".equals(method)) {
            while (i < num) {
                slotsobject.setId(i + 1);
                slotsobject.setLevel(3);
                slotsobject.setState(1);
                slotsobject.setDescmsg(i);

                Map map = new HashMap();
                map.put("id", i);
                map.put("group_id", "");
                map.put("action", "");
//                map.put("delete", "否");
                slotsobject.setContent(mapper.writeValueAsString(map));
                slotsobjectMapper.insertSelective(slotsobject);
                i++;
            }
        } else if ("clean".equals(method)) {
            while (i < num) {
                slotsobject.setPid(null);

                Map map = new HashMap();
                map.put("id", i);
                map.put("group_id", "");
                map.put("action", "");
                slotsobject.setContent(mapper.writeValueAsString(map));
                slotsobjectMapper.insertSelective(slotsobject);
                i++;
            }
        }
        return Result.newSuccess(null);
    }

    /**
     * @Description:09 输入Slot目标Group ID
     */
    @RequestMapping(value = "enterslottargetgroupid", method = RequestMethod.POST)
    public Result enterslottargetgroupid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(9);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:10 确认Migrate Range数据块
     */
    @RequestMapping(value = "confirmmigraterangedatablock", method = RequestMethod.POST)
    public Result confirmmigraterangedatablock() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(10);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:11 设置是否迁移
     */
    @RequestMapping(value = "settingwhethertomigrate", method = RequestMethod.POST)
    public Result settingwhethertomigrate(
            @RequestParam(required = true)String onoff
    ) throws IOException {
        Dictionary003 dictionary00301 = dictionary003Mapper.selectByPrimaryKey(70);
        Map map1 = mapper.readValue(dictionary00301.getContent(),Map.class);
        if ("on".equals(onoff)){
            map1.put("disable","开");
        }
        if ("off".equals(onoff)){
            map1.put("disable","关");
        }
        dictionary00301.setContent(mapper.writeValueAsString(map1));
        dictionary003Mapper.updateByPrimaryKey(dictionary00301);


        if ("on".equals(onoff)){
            disableon();
        }






        Dictionary003 dictionary00302 = dictionary003Mapper.selectByPrimaryKey(70);
        Map map2 = mapper.readValue(dictionary00302.getContent(),Map.class);

        return Result.newSuccess(map2);
    }

    /**
     * @Description:12 设置迁移数据块间隔
     */
    @RequestMapping(value = "tosetthemigrationdatablockinterval", method = RequestMethod.POST)
    public Result tosetthemigrationdatablockinterval(
            @RequestParam(required = true)String interval
    ) throws IOException {
        Dictionary003 dictionary00301 = dictionary003Mapper.selectByPrimaryKey(20);
        Map map1 = mapper.readValue(dictionary00301.getContent(), Map.class);
        map1.put("interval",interval);

        dictionary00301.setContent(mapper.writeValueAsString(map1));
        dictionary003Mapper.updateByPrimaryKey(dictionary00301);

        Dictionary003 dictionary00302 = dictionary003Mapper.selectByPrimaryKey(20);
        Map map2 = mapper.readValue(dictionary00302.getContent(),Map.class);

        return Result.newSuccess(map2);
    }

    /**
     * @Description:13 显示动作Status
     */
    @RequestMapping(value = "showactionstatus", method = RequestMethod.POST)
    public Result showactionstatus() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(13);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:14 设置迁移动作是否显示
     */
    @RequestMapping(value = "setwhetherthemigrationactiondisplays", method = RequestMethod.POST)
    public Result setwhetherthemigrationactiondisplays() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(14);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:15 显示迁移Slot ID
     */
    @RequestMapping(value = "showmigratedslotids", method = RequestMethod.POST)
    public Result showmigratedslotids() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(15);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:16 显示迁移Group ID
     */
    @RequestMapping(value = "showmigrationgroupid", method = RequestMethod.POST)
    public Result showmigrationgroupid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(16);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:17 显示迁移目标Group ID
     */
    @RequestMapping(value = "showmigrationtargetgroupid", method = RequestMethod.POST)
    public Result showmigrationtargetgroupid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(17);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:18 显示迁移Index位置
     */
    @RequestMapping(value = "showmigrationindexlocation", method = RequestMethod.POST)
    public Result showmigrationindexlocation() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(18);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:19 显示迁移状态
     */
    @RequestMapping(value = "showmigrationstatus", method = RequestMethod.POST)
    public Result showmigrationstatus() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(19);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:20 删除迁移slot
     */

    //删除
    @RequestMapping(value = "removemigrationslot", method = RequestMethod.POST)
    public Result removemigrationslot(
            @RequestParam(required = true) int slotid
    ) throws IOException {
        slotsobjectExample example = new slotsobjectExample();
        slotsobjectExample.Criteria criteria = example.createCriteria();
        criteria.andDescmsgEqualTo(slotid);
        List<slotsobject> list = slotsobjectMapper.selectByExample(example);
        for (slotsobject d : list) {
            slotsobject slotsobject = new slotsobject();
            slotsobject.setId(d.getId());
            slotsobject.setPid(d.getPid());
            slotsobject.setLevel(3);
            slotsobject.setState(1);
            slotsobject.setDescmsg(d.getDescmsg());

            Map map = mapper.readValue(d.getContent(), Map.class);
            map.put("group_id", map.get("group_id"));
            map.put("action", "");
            map.put("id", map.get("id"));
            map.put("delete", "否");
            slotsobject.setContent(mapper.writeValueAsString(map));
            slotsobjectMapper.updateByPrimaryKey(slotsobject);
        }


        return Result.newSuccess(null);
    }


    /**
     * @Description:迁移方法
     */
    private void saocaozuo(String slotbeginid, String slotendid, String targetgroupid, String actionstatus) throws IOException {
        slotsobjectExample example2 = new slotsobjectExample();
        slotsobjectExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andDescmsgBetween(Integer.valueOf(slotbeginid), Integer.valueOf(slotendid));
        List<slotsobject> list2 = slotsobjectMapper.selectByExample(example2);

//        int index = 0;
        for (slotsobject d : list2) {

            slotsobject slotsobject = new slotsobject();
//            slotsobject.setId(d.getId());
//            slotsobject.setPid(d.getPid());
//            slotsobject.setDescmsg(d.getDescmsg());
//            slotsobject.setLevel(3);
//            slotsobject.setState(1);

            Map map = new HashMap();
            Map map1 = mapper.readValue(d.getContent(), Map.class);

//            map.put("index", index + "");
            map.put("state", actionstatus);
//            map.put("target_id", targetgroupid);
//            map.put("delete", "是");

            map1.put("action", map);
//            if ("disableoff".equals(method)){
//                map1.put("delete", "否");
//            }

            slotsobject.setContent(mapper.writeValueAsString(map1));

//            if ("disableoff".equals(method)){
//                slotsobjectMapper.updateByPrimaryKey(slotsobject);
//            }

//            if ("disableon".equals(method)){
                slotsobjectExample example = new slotsobjectExample();
                slotsobjectExample.Criteria criteria = example.createCriteria();
                criteria.andContentLike("%index%");
                slotsobjectMapper.updateByExampleSelective(slotsobject, example);
//            }


//            index++;
        }
    }

    /**
     * @Description:开启开关时去扫出pending状态的
     */
    private void disableon() throws IOException {

        slotsobjectExample example = new slotsobjectExample();
        slotsobjectExample.Criteria criteria = example.createCriteria();
        criteria.andContentLike("%pending%");
        List<slotsobject> list = slotsobjectMapper.selectByExample(example);
        log.info("pending list"+list.size());
        for (slotsobject d : list){

            slotsobject slotsobject = new slotsobject();


            Map map1 = mapper.readValue(d.getContent(), Map.class);
            Map map = new HashMap();

            Map map33 = (Map)map1.get("action");

            map.put("index",map33.get("index"));
            map.put("target_id",map33.get("target_id"));
            map.put("state", "migrating");





            log.info("!!@#@#$@$@$@#@taget_id:"+ map33.get("target_id"));

            map1.put("action", map);

            slotsobject.setContent(mapper.writeValueAsString(map1));

            slotsobjectExample example1 = new slotsobjectExample();
            slotsobjectExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andContentLike("%index%");
            slotsobjectMapper.updateByExampleSelective(slotsobject, example1);







            slotsobject slotsobject1 = new slotsobject();

            Map map2 = new HashMap();
            Map map3 = mapper.readValue(d.getContent(), Map.class);

            map2.put("index",map1.get("index"));
            map2.put("target_id",map33.get("target_id"));
            map2.put("state", "finished");

            map3.put("action", map2);

            slotsobject1.setContent(mapper.writeValueAsString(map3));

            slotsobjectExample example2 = new slotsobjectExample();
            slotsobjectExample.Criteria criteria2 = example2.createCriteria();
            criteria2.andContentLike("%index%");
            slotsobjectMapper.updateByExampleSelective(slotsobject1, example2);




            log.info("!!!!!!target_id = "+ map2.get("target_id"));
            Dictionary003Example example10 = new Dictionary003Example();
            Dictionary003Example.Criteria criteria10 = example10.createCriteria();
            criteria10.andContentLike("%" + map33.get("target_id") + "%");
            int pid = 0;//服务组表id
            String groupid = "";
            List<Dictionary003> list1 = dictionary003Mapper.selectByExample(example10);
            for (Dictionary003 dd : list1) {
                pid = dd.getPid();

                JSONObject jsonObject = JSONObject.fromObject(dd.getContent());
                groupid = jsonObject.getString("servergroupid");
            }
            log.info("pid = " + pid);
            log.info("servergroupid = " + groupid);





            //迁移完毕，更新为目标组的pid，greoup_id，移除action对象
            slotsobjectExample example3 = new slotsobjectExample();
            slotsobjectExample.Criteria criteria3 = example3.createCriteria();
            criteria3.andContentLike("%index%");
            List<slotsobject> list3 = slotsobjectMapper.selectByExample(example3);
            for (slotsobject ddd : list3) {
                slotsobject slotsobject11 = new slotsobject();
                slotsobject11.setId(ddd.getId());
                slotsobject11.setPid(pid);
                slotsobject11.setLevel(3);
                slotsobject11.setState(1);
                slotsobject11.setDescmsg(ddd.getDescmsg());

                Map map003 = mapper.readValue(ddd.getContent(), Map.class);
                map003.put("group_id", groupid);
                map003.put("action", "");
                map003.put("id", ddd.getDescmsg());
                slotsobject11.setContent(mapper.writeValueAsString(map003));
                slotsobjectMapper.updateByPrimaryKey(slotsobject11);
            }
        }

        return;
    }
}
