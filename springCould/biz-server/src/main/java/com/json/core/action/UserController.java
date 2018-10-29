package com.json.core.action;

import com.json.core.dao.UserMapper;
import com.json.core.domain.User;
import com.json.core.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "用户信息管理")
@RestController
@RequestMapping(value="/user") // 通过这里配置使下面的映射都在/users下，可去除
@Slf4j
public class UserController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private UserMapper mapper;


    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value="/getUserList", method= RequestMethod.GET)
    public List<User> getUserList() {

        //测试redis
        redisUtil.set("json","6666");
        return mapper.selectAll();
    }

    @ApiOperation(value="创建用户", notes="创建用户")
    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        //return "success";
        //Long l = new Date().getTime();
        //User user = new User(l.intValue(), "json","123");

        //测试redis
        String val = redisUtil.get("json");
        log.info("获取redis值为,json:[{}]",val);

        int i = mapper.insert(user);
        return "success" + String.valueOf(i);
    }

    @ApiOperation(value="获取用户详细信息", notes="获取用户详细信息")
    @RequestMapping(value="/getDetail", method= RequestMethod.GET)
    public User getDetail(@RequestParam(value = "id") int id) {
        return mapper.selectById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="更新用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@RequestParam(value = "id") int id, @RequestBody User user) {
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        return "success";
    }
}
