package com.mooc.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloRestApi {

    @RequestMapping(value = "getAdmin",method = RequestMethod.GET)
    @ResponseBody
    public String getAdmin () {
        return "hello admin";
    }
}
