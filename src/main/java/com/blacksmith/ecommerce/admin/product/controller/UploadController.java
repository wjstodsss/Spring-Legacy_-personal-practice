package com.blacksmith.ecommerce.admin.product.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext; // 추가

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @Autowired
    private ServletContext servletContext; // ServletContext 주입

   
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("uploadFiles") MultipartFile[] files, Model model) {
        // 파일 저장 경로 설정
        String uploadPath = servletContext.getRealPath("/upload");

        // 업로드 디렉토리 생성
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            // 파일 저장
        	List<String> fileNames = new ArrayList<>();
        	for (MultipartFile file : files) {
        		String fileName = file.getOriginalFilename();
        		File dest = new File(uploadDir.getAbsolutePath() + File.separator + fileName);
                System.out.println(dest);
                file.transferTo(dest);
                fileNames.add(fileName);
        	}
            
            
            // 모델에 파일명 추가
            model.addAttribute("fileNames", fileNames);

            // 성공 페이지로 이동
            return "admin/secured/success";
        } catch (IOException e) {
            e.printStackTrace();
            // 실패 페이지로 이동
            return "error";
        }
        
        
    }

@GetMapping("/upload/{fileName:.+}")
public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
    // 파일 경로 설정
    String uploadDirectory = servletContext.getRealPath("/upload");
    Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
    Resource resource;
    try {
        resource = new UrlResource(filePath.toUri());
        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        }
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return ResponseEntity.notFound().build();
}
    
    
    
}
