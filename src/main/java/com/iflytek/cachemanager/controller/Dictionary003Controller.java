package com.iflytek.cachemanager.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iflytek.cachemanager.entity.Dictionary003;
import com.iflytek.cachemanager.mapper.Dictionary003Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: zhujunhua
 * @date: 2018/4/10
 * @description:
 */
@RestController
public class Dictionary003Controller {
    @Autowired
    private Dictionary003Mapper dictionary003Mapper;

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description:01 显示Slots各分组数据大小
     */
    @RequestMapping(value = "displayslotsgroupeddatasizes", method = RequestMethod.POST)
    public Result displayslotsgroupeddatasizes() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(1);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
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
    public Result confirmmigratedatablock() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(6);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
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
     * @Description:08 输入Slot结束ID
     */
    @RequestMapping(value = "enterslotendid", method = RequestMethod.POST)
    public Result enterslotendid() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(8);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
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
    public Result settingwhethertomigrate() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(11);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }

    /**
     * @Description:12 设置迁移数据块间隔
     */
    @RequestMapping(value = "tosetthemigrationdatablockinterval", method = RequestMethod.POST)
    public Result tosetthemigrationdatablockinterval() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(12);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
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
    @RequestMapping(value = "removemigrationslot", method = RequestMethod.POST)
    public Result removemigrationslot() throws IOException {
        Dictionary003 dictionary003 = dictionary003Mapper.selectByPrimaryKey(20);
        JsonNode jsonNode = mapper.readTree(dictionary003.getContent());
        return Result.newSuccess(jsonNode);
    }
}
