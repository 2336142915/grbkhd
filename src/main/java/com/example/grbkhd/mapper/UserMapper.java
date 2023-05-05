package com.example.grbkhd.mapper;

import com.example.grbkhd.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xlz
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-04-03 20:52:55
* @Entity com.example.grbkhd.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




