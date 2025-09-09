import model.BaseFile;
import model.TextFile;
import service.FileAnalyzer;
import service.FileParser;
import service.ReportGenerator;
import service.impl.TextFileAnalyzer;
import service.impl.TextFileParser;
import service.impl.TextFileReportGenerator;

import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("Enter url:");
            Scanner scanner = new Scanner(System.in);
            String url = scanner.nextLine();
            scanner.close();

            FileParser<TextFile> textFileFileParser = new TextFileParser();
            TextFile textFile = textFileFileParser.parse(url);

            FileAnalyzer<TextFile> textFileAnalyzer = new TextFileAnalyzer();
            textFileAnalyzer.analyze(textFile);


            ReportGenerator<TextFile> textFileReportGenerator = new TextFileReportGenerator();
            for (Map.Entry<String, Integer> entry: textFile.getWordToCount().entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            System.out.println(textFileReportGenerator.generate(textFile));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
