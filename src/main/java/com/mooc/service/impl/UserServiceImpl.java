package com.mooc.service.impl;

import com.mooc.mapper.UserMapper;
import com.mooc.pojo.User;
import com.mooc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {

        return userMapper.getUserById(id);

    }

    @Override
    public List<User> listUser() {
        return userMapper.selectUsers();
    }
}
