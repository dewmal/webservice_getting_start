package com.ijse.application.dayeight.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProviderChain;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import software.amazon.awssdk.core.sync.RequestBody;

import java.io.*;
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
        String bucketName = "com.ijse.awsclass.day8";
        String objectKey = "test_file";


        Region region = Region.EU_WEST_1;
        S3Client s3 = S3Client.builder()
                .region(region)
                .build();

        PutObjectResponse response = s3.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(objectKey)
                        .build(),
                RequestBody.fromFile(uploadedFile)
        );
        System.out.println(response.eTag());


        return "DONE";
    }
}
