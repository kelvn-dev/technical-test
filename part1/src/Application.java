package part1;

import part1.model.TextFile;
import part1.service.FileAnalyzer;
import part1.service.FileParser;
import part1.service.ReportGenerator;
import part1.service.impl.TextFileParser;
import part1.service.impl.TextFileReportGenerator;
import part1.service.impl.TextFileAnalyzer;

public class Application {
    public static void main(String[] args) {
        // TODO: Apply singleton as DI in spring
        String url = "static/example.txt";

        FileParser<TextFile> fileParser = new TextFileParser();
        TextFile textFile = fileParser.parse(url);

        FileAnalyzer<TextFile> textAnalyzer = new TextFileAnalyzer();
        textAnalyzer.analyze(textFile);

        ReportGenerator<TextFile> reportGenerator = new TextFileReportGenerator();
        System.out.println(reportGenerator.generate(textFile));
    }
}
