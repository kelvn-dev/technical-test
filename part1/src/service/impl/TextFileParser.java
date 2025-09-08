package service.impl;


import model.TextFile;
import service.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileParser extends BaseFileParser implements FileParser<TextFile> {

    @Override
    public TextFile parse(String url) throws IOException {
        File file = new File(url);

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Error parsing file: " + e.getMessage());
        }

        String fileContent = stringBuilder.toString().trim();

        TextFile textFile = new TextFile();
        textFile.setContent(fileContent);
        textFile.setContentType(this.getContentType(url));
        textFile.setContentLength(this.getContentLength(url));

        return textFile;
    }
}
