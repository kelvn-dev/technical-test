package model;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TextFile extends BaseFile {

    private String content;
    private int wordCount;
    private int distinctWordCount;
    private Map<String, Integer> wordToCount;

    public TextFile() {

    }

    public TextFile(String content, int wordCount, int distinctWordCount, Map<String, Integer> wordToCount) {
        this.content = content;
        this.wordCount = wordCount;
        this.distinctWordCount = distinctWordCount;
        this.wordToCount = wordToCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getDistinctWordCount() {
        return distinctWordCount;
    }

    public void setDistinctWordCount(int distinctWordCount) {
        this.distinctWordCount = distinctWordCount;
    }

    public Map<String, Integer> getWordToCount() {
        return wordToCount;
    }

    public void setWordToCount(Map<String, Integer> wordToCount) {
        this.wordToCount = wordToCount;
    }

    public void sortWordToCountByCountDesc() {
        if (Objects.isNull(wordToCount) || wordToCount.isEmpty()) {
            return;
        }

        this.wordToCount = wordToCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public Map<String, Integer> getTopKFrequentWords(int k) {
        Map<String, Integer> topK = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            topK.put(entry.getKey(), entry.getValue());
            if (++count == k) {
                break;
            }
        }
        return topK;
    }
}
