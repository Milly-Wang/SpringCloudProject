package cn.milly.user.controller;

import cn.milly.user.pojo.User;
import cn.milly.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController   //@RestController = @RequestMapping+ResponseBody
@Api(description = "用户核心api")
public class UserController {

    @Autowired
    private UserService userService;
    //find all user
    @ApiOperation(value = "查找所有用户")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {

//        List<User> list = new ArrayList<>();
//        list.add(new User(1, "milly","123456","female", 1000.0));
//        list.add(new User(2, "milly2","123456","female", 2000.0));
//        list.add(new User(3, "milly3","123456","female", 3000.0));

        return userService.findAll();
    }
    @ApiOperation(value = "查找指定用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Integer id) {
        System.out.println("microservice-user1111");
        return userService.findById(id);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user) {
        userService.add(user);
        return "Add Successfully";
    }

    @ApiOperation(value = "更新用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        userService.update(user);
        return "Update Successfully";
    }

    @ApiOperation(value = "删除指定用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return "Delete Successfully";
    }


}

