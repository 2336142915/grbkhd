package com.example.grbkhd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.grbkhd.pojo.Shuoshuo;
import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.service.ShuoshuoService;
import com.example.grbkhd.util.R;
import com.example.grbkhd.util.TokenCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class ShuoShuoController {

    @Autowired
    private ShuoshuoService shuoshuoService;

    @GetMapping("/sslist")
    public R<List> sslst(String title){
        if (title==null){
            title="";
        }
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.like("title",title);
        List<Shuoshuo> list = shuoshuoService.list(wrapper);
        return R.success(list);
    }

    @GetMapping("/getdetail")
    public R<Shuoshuo> getDetailById(@RequestParam Integer id){
        Shuoshuo by = shuoshuoService.getById(id);
        System.out.println(by);
        int i = by.getLiulan();
        i++;
        by.setLiulan(i);
        shuoshuoService.updateById(by);
        return R.success(by);
    }

    @PostMapping("/deletess")
    public R<String> deletess(@RequestBody Shuoshuo shuoshuo, HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean b = shuoshuoService.removeById(shuoshuo);
            if (b){
                return R.success("删除成功");
            }
            return R.error("删除失败");
        }
        return R.error("只有管理员可以操作");
    }

    @PostMapping("/updatess")
    public R<String> updatess(@RequestBody Shuoshuo shuoshuo,HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean b = shuoshuoService.updateById(shuoshuo);
            if (b){
                return R.success("修改成功");
            }
            return R.error("修改失败");
        }
        return R.error("只有管理员可以操作");
    }

    @PostMapping("/addss")
    public R<String> addss(@RequestBody Shuoshuo shuoshuo,HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            if (shuoshuo!=null){
                shuoshuo.setRemen(0);
                shuoshuo.setPinglun(0);
                shuoshuo.setLiulan(0);
                shuoshuo.setDianzan(0);
                Date date = new Date();
                System.out.println(date);
                shuoshuo.setDate(date);
            }
            System.out.println(shuoshuo);
            boolean save = shuoshuoService.save(shuoshuo);
            if (save){
                return R.success("添加成功");
            }
            return R.error("添加失败");
        }
        return R.error("只有管理员可以操作");
    }
}
