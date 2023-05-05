package com.example.grbkhd.controller;


import com.example.grbkhd.pojo.Gonggao;
import com.example.grbkhd.pojo.Token;
import com.example.grbkhd.service.GonggaoService;
import com.example.grbkhd.util.R;
import com.example.grbkhd.util.TokenCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
public class GonggaoController {

    @Autowired
    private GonggaoService service;

    @GetMapping("/gglist")
    public R<List<Gonggao>> gglist(){
        List<Gonggao> list = service.list();
        return R.success(list);
    }

    @PostMapping("/addgg")
    public R<String> addgg(@RequestBody Gonggao gonggao, HttpServletRequest request){
        if((boolean)request.getAttribute("state")){
            boolean save = service.save(gonggao);
            if (save){
                return R.success("添加成功");
            }
            return R.error("添加失败");
        }
        return R.error("只有管理员可以操作");
    }

}
