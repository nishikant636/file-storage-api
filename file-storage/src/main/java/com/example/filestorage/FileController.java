package com.example.filestorage;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

@RestController
public class FileController {

    private static final String STORAGE_DIR = "uploads";

    public FileController() throws IOException {
        Files.createDirectories(Paths.get(STORAGE_DIR));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        Path targetPath = Paths.get(STORAGE_DIR).resolve(filename);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.ok("File uploaded: " + filename);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String filename) throws IOException {
        Path filePath = Paths.get(STORAGE_DIR).resolve(filename);
        byte[] fileBytes = Files.readAllBytes(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }
}