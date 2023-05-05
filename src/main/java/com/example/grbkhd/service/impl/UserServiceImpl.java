package com.example.grbkhd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.grbkhd.pojo.User;
import com.example.grbkhd.service.UserService;
import com.example.grbkhd.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author xlz
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-04-03 20:52:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




