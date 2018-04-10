package com.iflytek.cachemanager.controller;

import com.iflytek.cachemanager.entity.Dictionary005;
import com.iflytek.cachemanager.mapper.Dictionary005Mapper;
import com.iflytek.cachemanager.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tishen
 * @date: 2018/4/10
 * @description:
 */
@RestController
public class Dictionary005Controller {

    @Autowired
    private Dictionary005Mapper dictionary005Mapper;

    @RequestMapping(value = "fileDataProcessingServiceStatus2", method = RequestMethod.GET)
    public Result fileDataProcessingServiceStatus() {
        Dictionary005 dictionary001 = dictionary005Mapper.selectByPrimaryKey(1);
        return Result.newSuccess(dictionary001.getContent());
    }

}
