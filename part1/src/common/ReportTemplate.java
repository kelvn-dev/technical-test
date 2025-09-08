package common;

public class ReportTemplate {
    public static final String TEXT_FILE_REPORT_TEMPLATE =
            "Total Word Count: ${wordCount}\n" +
            "Top 5 Most Frequent Words:\n" +
            "${topKFrequentWords}\n" +
            "Number of Unique Words: ${distinctWordCount}";

    public static final String TOP_K_FREQUENT_WORDS_TEXT_FILE_REPORT_TEMPLATE =
            "${word} - ${wordCount} (${percentage}%)";
}
