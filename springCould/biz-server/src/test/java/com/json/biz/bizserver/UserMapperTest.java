package com.json.biz.bizserver;/*
package com.json.demo.springBootDemo;

import com.json.demo.dao.UserMapper;
import com.json.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.json.demo.dao")
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testInset() {
        Long l = new Date().getTime();
        User user = new User(l.intValue(), "json","123");
        int i = mapper.insert(user);
        System.out.println("===============:"+i);
        //Assert.assertNotEquals(0, i);
    }
   */
/* @Test
    public void testSelect(){
        User user = mapper.selectByName("Jaycekon");
        //Assert.assertNotEquals(null,user);
    }*//*

}*/
