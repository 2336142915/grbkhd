package com.example.grbkhd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.pojo.User;
import com.example.grbkhd.service.UserService;
import com.example.grbkhd.util.R;
import com.example.grbkhd.util.SaticScheduleTask;
import com.example.grbkhd.util.TokenCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<String> login(@RequestBody User user){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",user.getUsername());
        wrapper.eq("password",user.getPassword());
        User one = userService.getOne(wrapper);
        if (one!=null){
            String token = TokenCreate.getoken(one);
            System.out.println(token);
            SaticScheduleTask.liu++;
            System.out.println(SaticScheduleTask.liu);
            return R.success(token);
        }
        return R.error("登录错误！请检查账号或者密码");
    }

    @GetMapping("/tokenlogin")
    public R<String> tokenlogin(@RequestParam String token){
        TokenCreate.tokenToOut(token);
        return R.success("111");
    }
    @GetMapping("/userdetail")
    public R<User> userdetail(HttpServletRequest request){
        String header = request.getHeader("token");
        Token token = TokenCreate.tokenToOut(header);
        System.out.println(token);
        String username = token.getUsername();
        User by = userService.getById(username);
        return  R.success(by);
    }

    @GetMapping("/userlist")
    public R<List<User>> userlist(){
        List<User> list = userService.list();
        return R.success(list);
    }

    @PostMapping("/adduser")
    public R<String> adduser(@RequestBody User user,HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean save = userService.save(user);
            if (save){
                return R.success("添加成功");
            }
            return R.error("添加失败");
        }
        return R.error("只有管理员可以操作");
    }

    @PostMapping("/removeuser")
    public R<String> removeuser(@RequestBody User user,HttpServletRequest request){
        String token = request.getHeader("token");
        if((boolean)request.getAttribute("state")){
            boolean save = userService.removeById(user);
            if (save){
                return R.success("删除成功");
            }
            return R.error("删除失败");
        }
        return R.error("只有管理员可以操作");
    }

    @PostMapping("/updateuser")
    public R<String> updateuser(@RequestBody User user,HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean b = userService.updateById(user);
            if (b){
                return R.success("修改成功");
            }
            return R.error("修改失败");
        }
        return R.error("只有管理员可以操作");
    }
}

