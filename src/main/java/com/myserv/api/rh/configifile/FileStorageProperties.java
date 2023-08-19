package com.myserv.api.rh.configifile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "file")
@Component
public class FileStorageProperties {
    private String uploadfilecvDir;

    public String getUploadFileCvDir() {
        return uploadfilecvDir;
    }

    public void setUploadFileCvDir(String uploadfilecvDir) {
        this.uploadfilecvDir = uploadfilecvDir;
    }
}
