package com.spring.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {
    private static final String FOLDER = "images//";

    public String saveImage(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
        }
        return "default.jpg";
    }

    public void delete(String imageName) {
        File file = new File(FOLDER + imageName);
        file.delete();
    }
}
