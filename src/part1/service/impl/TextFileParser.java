package part1.service.impl;

import part1.model.TextFile;
import part1.service.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileParser extends BaseFileParser implements FileParser<TextFile> {

    @Override
    public TextFile parse(String url) {
        File file = new File(url);

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            // Throw exception
        }

        String fileContent = stringBuilder.toString().trim();

        TextFile textFile = new TextFile();
        textFile.setContent(fileContent);
        textFile.setContentType(this.getContentType(url));
        textFile.setContentLength(this.getContentLength(url));

        return textFile;
    }
}
