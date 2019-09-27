package restful.controller;


import org.springframework.web.bind.annotation.*;
import restful.po.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
public class UserController {

       private List<User> userList = Collections.synchronizedList(new ArrayList<User>());

       //新增

    @PostMapping("/users")
    @ApiOperation(value = "新增用户",notes ="根据表单新增用户" )
    @ApiImplicitParam(name = "user",value = "用户实体类",required = true,dataType = "User")
    public String addUser(User user){
        try {
            userList.add(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

    //查看
    @GetMapping("/users")
    public List findAll(){

        return userList;
    }

    //修改
    @PutMapping("/users/{id}")
    public String update(@PathVariable("id") Integer id,User user){
        for (User user1 : userList) {
            if (user1.getId()==id){
                user1.setName(user.getName());
                user1.setAddress(user.getAddress());
            }
        }
        return "success";
    }
    //删除
    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Integer id){
        for (User user : userList) {
            if (user.getId()==id){
                userList.remove(user);
            }
        }
        return "success";
    }


}
