package com.ijse.application.dayeight.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileUploadController {

    @GetMapping("/api/upload")
    @ResponseBody
    public String uploadedData() {
        return "DONE";
    }

    @PostMapping("/api/upload")
    @ResponseBody
    public String uploadData(@RequestParam("file") MultipartFile file) {
//        System.out.println(file.get);
        File uploadedFile = new File(file.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(uploadedFile)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "DONE";
    }
}
