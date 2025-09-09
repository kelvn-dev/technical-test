package service.impl;

import config.ReportTemplateConfig;
import enums.ReportTemplateEnum;
import model.TextFile;
import service.ReportGenerator;
import utils.StringUtils;

import java.util.Map;

public class TextFileReportGenerator implements ReportGenerator<TextFile> {

    private static final int NUMBER_OF_TOP_K = 5;

    @Override
    public String generate(TextFile textFile) {
        String textFileReportTemplate = ReportTemplateConfig.FILE_REPORT_TEMPLATE.get(ReportTemplateEnum.TEXT_FILE.toString());
        String topKFrequentWordsTemplate = ReportTemplateConfig.FILE_REPORT_TEMPLATE.get(ReportTemplateEnum.TOP_K_FREQUENT_WORDS_TEXT_FILE.toString());

        if (StringUtils.isEmpty(textFileReportTemplate) || StringUtils.isEmpty(topKFrequentWordsTemplate)) {
            throw new IllegalStateException("Pre-configure report template is missing");
        }

        Map<String, Integer> topKFrequentWords = textFile.getTopKFrequentWords(NUMBER_OF_TOP_K);

        StringBuilder topKFrequentWordsReport = new StringBuilder();
        topKFrequentWords.forEach((key, value) -> {
            String topKFrequentWordsRecord = topKFrequentWordsTemplate
                    .replace("${word}", key)
                    .replace("${wordCount}", value.toString())
                    .replace("${percentage}", String.format("%.2f", ((double) value / textFile.getWordCount()) * 100));
            topKFrequentWordsReport.append(topKFrequentWordsRecord).append(System.lineSeparator());
        });

        return textFileReportTemplate
                .replace("${wordCount}", String.valueOf(textFile.getWordCount()))
                .replace("${distinctWordCount}", String.valueOf(textFile.getDistinctWordCount()))
                .replace("${topKFrequentWords}", topKFrequentWordsReport.toString().trim());
    }
}
