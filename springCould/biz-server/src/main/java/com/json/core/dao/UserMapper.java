package com.json.core.dao;

import com.json.core.domain.User;
import com.json.core.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends MyMapper<User> {

    @Select("select * from user where user_name = #{username}")
    User selectByName(String username);

    @Select("select * from user where id = #{id}")
    User selectById(int id);

}
