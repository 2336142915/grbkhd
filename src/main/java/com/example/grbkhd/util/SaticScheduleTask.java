package com.example.grbkhd.util;

import com.example.grbkhd.pojo.Liulan;
import com.example.grbkhd.service.LiulanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
public class SaticScheduleTask {

    @Autowired
    private LiulanService service;
    public static int liu;

    @Scheduled(fixedRate = 60000*60*24)
    public void addLiulan(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format+"  "+liu);
        Liulan liulan = new Liulan();
        liulan.setDate(date);
        liulan.setLiulan(liu);
        boolean save = service.save(liulan);
    }
}

