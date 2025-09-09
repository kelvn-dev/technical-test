package service.impl;

import model.TextFile;
import service.FileAnalyzer;
import utils.RegexUtils;
import utils.StringUtils;

import java.util.*;

public class TextFileAnalyzer implements FileAnalyzer<TextFile> {

    /**
     * Count total words, distinct words and per-word frequencies
     *
     * @param file
     * @return TextFile
     */
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

        file.setWordCount(totalWordCount);
        file.setDistinctWordCount(totalDistinctWordCount);
        file.setWordToCount(wordToCount);

        file.sortWordToCountByCountDesc();

        return file;
    }


}
