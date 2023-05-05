package com.example.grbkhd.controller;

import com.example.grbkhd.pojo.Liulan;
import com.example.grbkhd.service.LiulanService;
import com.example.grbkhd.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LuiLanController {

    @Autowired
    private LiulanService liulanService;


    @GetMapping("/getll")
    public R<List<Liulan>> getll(){
        List<Liulan> list = liulanService.list();
        return R.success(list);
    }

}
