package com.mooc.service;

import com.mooc.pojo.User;

import java.util.List;

public interface UserService {
    public User getUser (Integer id);
    List<User> listUser ();
}
