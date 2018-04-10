package com.iflytek.cachemanager.controller;

import com.iflytek.cachemanager.entity.Dictionary006;
import com.iflytek.cachemanager.mapper.Dictionary006Mapper;
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
public class Dictionary006Controller {

    @Autowired
    private Dictionary006Mapper dictionary006Mapper;

    @RequestMapping(value = "fileDataProcessingServiceStatus2", method = RequestMethod.GET)
    public Result fileDataProcessingServiceStatus() {
        Dictionary006 dictionary001 = dictionary006Mapper.selectByPrimaryKey(1);
        return Result.newSuccess(dictionary001.getContent());
    }

}
