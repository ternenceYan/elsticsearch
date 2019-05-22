package com.mooc.mapper;

import com.mooc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserById (@Param("id") Integer id);
}
