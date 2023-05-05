package com.example.grbkhd.controller;


import com.example.grbkhd.pojo.Liulan;
import com.example.grbkhd.pojo.Liuyan;
import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.service.LiulanService;
import com.example.grbkhd.service.LiuyanService;
import com.example.grbkhd.util.R;
import com.example.grbkhd.util.TokenCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {POST,GET})
public class LiuyanController {

    @Autowired
    private LiuyanService service;


    @GetMapping("/getly")
    public R<List<Liuyan>> getly(){
        List<Liuyan> list = service.list();
        return R.success(list);
    }
    @PostMapping("/addly")
    public R<String> addly(@RequestBody Liuyan liuyan){
        liuyan.setDate(new Date());
        liuyan.setDianzan(0);
        boolean save = service.save(liuyan);
        if (save){
            return R.success("提交成功");
        }else{
            return R.error("提交失败");
        }
    }

    @PostMapping("/deletely")
    public R<String> deletely(@RequestBody Liuyan liuyan, HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean save = service.removeById(liuyan);
            if (save){
                return R.success("删除成功");
            }
            return R.error("删除失败");
        }
        return R.error("只有管理员可以操作");
    }

}
