package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public abstract class BaseFileParser {

    public long getContentLength(String url) {
        File file = new File(url);

        if (file.exists() && file.isFile()) {
            return file.length();
        } else {
            throw new FileSystemNotFoundException("File does not exist or is not a regular file");
        }
    }

    public String getContentType(String url) {
        Path filePath = Paths.get(url);

        try {
            String contentType = Files.probeContentType(filePath);
            if (Objects.nonNull(contentType)) {
                return contentType;
            } else {
                throw new IllegalArgumentException("Could not determine content type.");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error probing content type: " + e.getMessage());
        }
    }
}
