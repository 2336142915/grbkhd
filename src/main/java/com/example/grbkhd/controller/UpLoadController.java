package com.example.grbkhd.controller;


import com.example.grbkhd.util.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@RestController
@CrossOrigin
public class UpLoadController {

    @PostMapping("/uploadfile")
    public R<String> upLoadFile(MultipartFile file){
        String path = "G:\\io\\";
        String name = file.getOriginalFilename();
        String endName = name.substring(name.lastIndexOf("."));
        String name1 = path+ UUID.randomUUID()+endName;
        File file1 = new File(name1);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileOutputStream fileOutputStream = new FileOutputStream(name);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String s = "";
            if ((s = bufferedReader.readLine()) == null) {
                bufferedWriter.write(s);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success("成功");
    }
}
