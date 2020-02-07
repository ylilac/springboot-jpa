package com.yy.jpa.controller;

import com.yy.jpa.model.User;
import com.yy.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @ApiOperation("新增")
    @PostMapping(value = "/add")
//    @ApiImplicitParam(name="user",value = "用户信息",required = true,dataType = "string")
    public void insert(@RequestBody @ApiParam("新增用户信息") User user) {
        userService.insert(user);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/update")
    public void update(@RequestBody @ApiParam("修改用户信息") User user) {
        userService.update(user);
    }

    @ApiOperation("获取")
    @GetMapping(value = "/{id}/select")
    public User select(@PathVariable("id") @ApiParam("用户id") int id) {
        return userService.selectById(id);
    }

    @ApiOperation("分页")
    @GetMapping(value = "/selectAll/{pageNum}/{pageSize}")
    public List<User> selectAll(@PathVariable("pageNum") @ApiParam("页码（从0开始）") int pageNum, @PathVariable("pageSize") @ApiParam("每页显示条数") int pageSize) {
        Iterator<User> userIterator = userService.selectAll(pageNum, pageSize);
        List<User> list = new ArrayList<>();
        while (userIterator.hasNext()) {
            list.add(userIterator.next());
        }
        return list;
    }
}
