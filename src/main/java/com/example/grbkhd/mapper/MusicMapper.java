package com.example.grbkhd.mapper;

import com.example.grbkhd.pojo.Music;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xlz
* @description 针对表【music】的数据库操作Mapper
* @createDate 2023-04-03 14:49:44
* @Entity com.example.grbkhd.pojo.Music
*/
@Mapper
public interface MusicMapper extends BaseMapper<Music> {

}




