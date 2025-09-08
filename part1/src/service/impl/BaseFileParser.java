package service.impl;

import java.io.File;
import java.io.IOException;
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
            // TODO: Throw exception
            System.out.println("File does not exist or is not a regular file.");
            return 0;
        }
    }

    public String getContentType(String url) {
        Path filePath = Paths.get(url);

        try {
            String contentType = Files.probeContentType(filePath);
            if (Objects.nonNull(contentType)) {
                return contentType;
            } else {
                // TODO: Throw exception
                System.out.println("Could not determine content type.");
            }
        } catch (IOException e) {
            // TODO: Throw exception
            System.err.println("Error probing content type: " + e.getMessage());
        }
        return "";
    }
}
