package com.mooc.rest;

import com.mooc.pojo.User;
import com.mooc.resposity.EsUser;
import com.mooc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserRestApi {

    @Resource
    private UserService userService;
    @Autowired
    private EsUser esUser;

    @ApiOperation(value = "根据id获取用户信息",notes = "用户管理")
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ResponseBody
    public User get (@RequestParam(value = "id",required = false) Integer id) {
        return userService.getUser(id);
    }

    @ApiOperation(value = "保存用户到ES",notes = "用户管理")
    @RequestMapping(value = "saveUserEs",method = RequestMethod.GET)
    @ResponseBody
    public String save (@RequestParam(value = "id",required = false) Integer id) {
        User user = userService.getUser(id);
        esUser.save(user);
        return "success";
    }

    @ApiOperation(value = "从ES中根据名字和地址查询用户",notes = "用户管理")
    @RequestMapping(value = "getUserEs",method = RequestMethod.GET)
    @ResponseBody
    public User getOne (@RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "address",required = false) String address) {
        User user = esUser.findByUserNameOrAddress(name,address);
        return user;
    }

    @ApiOperation(value = "从ES中根据地址查询用户",notes = "用户管理")
    @RequestMapping(value = "getUserEsByAdd",method = RequestMethod.GET)
    @ResponseBody
    public User getUserByAdd (@RequestParam(value = "address",required = false) String address) {
        User user = esUser.findByMobile(address);
        return user;
    }

    @ApiOperation(value = "从ES中删除用户",notes = "用户管理")
    @RequestMapping(value = "deleteUserEs",method = RequestMethod.GET)
    @ResponseBody
    public String delete (@RequestParam(value = "id",required = false) Long id) {
        esUser.deleteById(id);
        return "success";
    }
}