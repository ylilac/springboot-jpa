package com.yy.jpa.controller;

import com.yy.jpa.model.User;
import com.yy.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(value = "用户接口", tags = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("删除")
    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id")int id){
        userService.delete(id);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/add")
    public void insert(@RequestBody User user){
        userService.insert(user);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @ApiOperation("获取")
    @GetMapping(value = "/{id}/select")
    public User select(@PathVariable("id")int id){
        return userService.selectById(id);
    }

    @ApiOperation("分页")
    @GetMapping(value = "/selectAll/{pageNum}/{pageSize}")
    public List<User> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        Iterator<User> userIterator = userService.selectAll(pageNum, pageSize);
        List<User> list = new ArrayList<>();
        while(userIterator.hasNext()){
            list.add(userIterator.next());
        }
        return list;
    }
}
