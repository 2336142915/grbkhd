package com.example.grbkhd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.grbkhd.pojo.Sspl;
import com.example.grbkhd.service.SsplService;
import com.example.grbkhd.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class SsplController {

    @Autowired
    private SsplService service;

    @GetMapping("/getpllist")
    public R<List<Sspl>> getplList(@RequestParam(required = false) Integer ssid){
        QueryWrapper wrapper = new QueryWrapper<>();
        if (ssid!=null){
            wrapper.eq("ssid",ssid);
        }
        List<Sspl> list = service.list(wrapper);
        return R.success(list);
    }

    @PostMapping("/addpl")
    public R<String> addpl(@RequestBody Sspl sspl){
        Date date = new Date();
        sspl.setDate(date);
        boolean save = service.save(sspl);
        if (save){
            return R.success("提交成功");
        }else{
            return R.error("提交失败");
        }
    }

    @PostMapping("/deletepl")
    public R<String> deletepl(@RequestBody Sspl sspl, HttpServletRequest request){
        if ((boolean)request.getAttribute("state")){
            boolean b = service.removeById(sspl);
            if (b){
                return R.success("删除成功");
            }
            return R.error("删除失败");
        }
        return R.error("只有管理员可以操作");
        }

}
