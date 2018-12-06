package com.core.controler;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.core.entity.UserTest;
import com.core.service.IUserTestService;
import com.json.util.Result;
import com.json.util.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author json
 * @since 2018-10-30
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/core/userTest")
public class UserTestController {

    @Autowired
    IUserTestService userTestService;

    @ApiOperation(value="查询所有用户", notes="查询所有用户")
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public Result<List<UserTest>> selectAll(){
        List<UserTest> list = userTestService.selectList(null);
        return Result.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),list);
    }

    @ApiOperation(value="获取用户详情", notes="获取用户详情")
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public Result<UserTest> getById(@RequestParam(value = "id") String id){
        UserTest user = userTestService.selectById(id);
        Result<UserTest> res =Result.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),user);
        return res;
    }

    @ApiOperation(value="删除用户", notes="删除用户")
    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Result<String> deleteById(@RequestParam(value = "id") String id){
        Boolean bool = userTestService.deleteById(id);
        return Result.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),bool.equals(true)?"true":"false");
    }

    @ApiOperation(value="用户分页", notes="用户分页")
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Result<Page<UserTest>> page(@RequestParam(value = "age") int age,@RequestParam(value = "name") String name){

        EntityWrapper<UserTest> wrapper = new EntityWrapper<UserTest>();
        wrapper.eq("age",age);
        wrapper.like("name",name);
        //Page page = new Page();
        //page.setCurrent(1);
        //page.setSize(10);;
        Page<UserTest> res = userTestService.selectPage(new Page<UserTest>(1, 10),wrapper);
        return Result.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),res);
    }

    @ApiOperation(value="保存用户", notes="保存用户")
    //@RequestMapping(value = "/save",method = RequestMethod.GET)
    @PostMapping(value = "/save", consumes = "application/json")
    public Result<String> save(@RequestBody UserTest user){
        Boolean bool = userTestService.insert(user);
        return Result.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),bool.equals(true)?"true":"false");
    }

    @ApiOperation(value="更新用户", notes="更新用户")
    //@RequestMapping(value = "/update",method = RequestMethod.GET)
    @PostMapping(value = "/update", consumes = "application/json")
    public Result<String> update(@RequestBody UserTest user){
        Boolean bool = userTestService.updateById(user);
        return Result.success(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),bool.equals(true)?"true":"false");
    }
}
