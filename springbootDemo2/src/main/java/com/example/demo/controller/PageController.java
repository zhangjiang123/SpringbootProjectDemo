package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(description="用户操作")
@RestController
@EnableAutoConfiguration
@RequestMapping("/page")
public class PageController {

        @Autowired
        UserService userService;

        @ApiOperation("分页查询")
        @RequestMapping(value = "/emp",method = RequestMethod.GET)
            public List findByPage(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn, Map<String,Object> map){

            System.out.println(pn);


            PageHelper.startPage(pn,3);
            List<User> allusers = userService.findAll();

            PageInfo pageInfo = new PageInfo<>(allusers);

            System.out.println(pageInfo);

            List list = pageInfo.getList();

            map.put("pageInfo",pageInfo);

            return list;


        }


}
