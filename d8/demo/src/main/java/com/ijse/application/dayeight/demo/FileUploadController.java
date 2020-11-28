package com.ijse.application.dayeight.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

@Controller
public class FileUploadController {

    @GetMapping("/api/upload")
    @ResponseBody
    public String uploadedData() {
        String bucketName = "com.ijse.awsclass.day8";
        String objectKey = "test_file";
        Region region = Region.EU_WEST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        ResponseBytes<GetObjectResponse> responseBytes = s3.getObject(GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build(), ResponseTransformer.toBytes());

        return responseBytes.asString(Charset.defaultCharset());
    }

    @PostMapping("/api/upload")
    @ResponseBody
    public String uploadData(@RequestParam("file") MultipartFile file) {


        File uploadedFile = new File(file.getOriginalFilename());

        try (OutputStream os = new FileOutputStream(uploadedFile)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        Region region = Region.EU_WEST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        ObjectCannedACL acl = ObjectCannedACL.PUBLIC_READ_WRITE;
        s3.putObject(PutObjectRequest.builder()
                .bucket("com.ijse.awsclass.day8")
                .key(uploadedFile.getName())
                .acl(acl)
                .build(), RequestBody.fromFile(uploadedFile));

        s3.close();


        return "DONE";
    }
}
