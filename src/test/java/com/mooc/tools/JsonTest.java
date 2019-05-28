package com.mooc.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mooc.pojo.User;
import com.mooc.util.JsonUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    @Test
    public void json () {
        User user = new User();
        user.setUserName("yanyy");
        user.setAge(12);
        user.setAddress("上海市");
        user.setMobile("13636387437");
        user.setPassword("123456");
        user.setSex("男");
        user.setId(1);
        User user1 = new User();
        user1.setUserName("xiaomi");
        user1.setAge(23);
        user1.setAddress("上海市");
        user1.setMobile("13636387437");
        user1.setPassword("123456");
        user1.setSex("男");
        user1.setId(2);

        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user1);
        String json = JsonUtils.toJson(list);
//        System.out.println(json);

//        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray jsonArray = JSONArray.parseArray(json);
        JSONObject jsonObject = (JSONObject) jsonArray.get(1);
        System.out.println(jsonObject.get("mobile"));
        System.out.println(jsonArray.get(1));
    }
}
