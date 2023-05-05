package com.example.grbkhd.controller;


import com.example.grbkhd.pojo.Music;
import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.service.MusicService;
import com.example.grbkhd.util.R;
import com.example.grbkhd.util.TokenCreate;
import com.example.grbkhd.util.UpLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {POST,GET})
public class MusicController {
    @Autowired
    private MusicService musicService;

    long date = System.currentTimeMillis()/1000;

    @GetMapping("/getmusiclist")
    public R<List<Music>> getMusicList(){
        List<Music> list = musicService.list();
        return R.success(list);
    }
    @GetMapping("/yxsj")
    public R<Long> sj(){
        long date1 = System.currentTimeMillis()/1000-date;
        System.out.println(date1+"时间戳");
        return R.success(date1);
    }

    @PostMapping("/removemusic")
    public R<String> removemusic(@RequestBody Music music, HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean b = musicService.removeById(music);
            if (b){
                return R.success("删除成功");
            }
            return R.error("删除失败");
        }
        return R.error("只有管理员可以操作");
    }

    @PostMapping("/upload")
    public R<String> upload(@RequestBody MultipartFile file,HttpServletRequest request){
        if ((boolean)request.getAttribute("state")){
            String path = "/www/wwwroot/default/image/";
            String fileName=file.getOriginalFilename();
            String newFileName = UpLoad.upload(file, path, fileName);
            if(newFileName != null){
                //上传成功
                return R.success("http://101.43.226.4:8099/test/"+newFileName);
            }else{
                return R.error("上传失败");
            }
        }else{
            return R.error("只有管理员可以上传文件");
        }
    }

    @PostMapping("/addmusic")
    public R<String> addmusic(@RequestBody Music music,HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean b = musicService.save(music);
            if (b){
                return R.success("添加成功");
            }
            return R.error("添加失败");
        }
        return R.error("只有管理员可以操作");
    }
}
