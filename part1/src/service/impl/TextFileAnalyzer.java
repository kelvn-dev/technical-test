package part1.service.impl;

import part1.model.BaseFile;
import part1.model.TextFile;
import part1.service.FileAnalyzer;
import utils.RegexUtils;
import utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TextFileAnalyzer implements FileAnalyzer<TextFile> {

    @Override
    public TextFile analyze(TextFile file) {
        int totalWordCount = 0;
        int totalDistinctWordCount = 0;
        Map<String, Integer> wordToCount = new HashMap<>();

        String fileContent = file.getContent();
        String[] words = fileContent.split(RegexUtils.WHITE_SPACE);

        for (String word: words) {
            String lowerCaseWord = word.toLowerCase();
            if (StringUtils.endsWithPunctuation(lowerCaseWord)) {
                lowerCaseWord = StringUtils.removePunctuation(lowerCaseWord);
            }

            int currentCount = wordToCount.getOrDefault(lowerCaseWord, 0);
            if (currentCount == 0) {
                ++totalDistinctWordCount;
            }
            ++totalWordCount;

            wordToCount.put(lowerCaseWord, currentCount + 1);
        }

        file.setContent(fileContent);
        file.setWordCount(totalWordCount);
        file.setDistinctWordCount(totalDistinctWordCount);
        file.setWordToCount(wordToCount);

        file.sortWordToCountByCountDesc();

        return file;
    }


}
