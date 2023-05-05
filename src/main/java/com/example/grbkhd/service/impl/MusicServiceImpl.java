package com.example.grbkhd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.grbkhd.pojo.Music;
import com.example.grbkhd.service.MusicService;
import com.example.grbkhd.mapper.MusicMapper;
import org.springframework.stereotype.Service;

/**
* @author xlz
* @description 针对表【music】的数据库操作Service实现
* @createDate 2023-04-03 14:49:44
*/
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music>
    implements MusicService{

}




