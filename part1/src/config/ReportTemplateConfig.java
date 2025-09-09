package config;


import common.ReportTemplate;
import enums.ReportTemplateEnum;

import java.util.Map;

public class ReportTemplateConfig {
    public static final Map<String, String> FILE_REPORT_TEMPLATE =
            Map.of(
                    ReportTemplateEnum.TEXT_FILE.toString(), ReportTemplate.TEXT_FILE_REPORT_TEMPLATE,
                    ReportTemplateEnum.TOP_K_FREQUENT_WORDS_TEXT_FILE.toString(), ReportTemplate.TOP_K_FREQUENT_WORDS_TEXT_FILE_REPORT_TEMPLATE
            );

    private ReportTemplateConfig() {}
}
