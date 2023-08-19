package com.myserv.api.rh.configifile;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface CvStorge {
    String store(MultipartFile file);
    Resource loadResource(String filename);

    void init();
    Stream<Path> loadFiles();
    ResponseEntity<Resource> downloadCvFile(String cvName, HttpServletRequest request);
}
