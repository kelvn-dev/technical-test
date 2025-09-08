import model.TextFile;
import service.FileAnalyzer;
import service.FileParser;
import service.ReportGenerator;
import service.impl.TextFileAnalyzer;
import service.impl.TextFileParser;
import service.impl.TextFileReportGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: Apply singleton as DI in spring
        String url = "part1/static/example.txt";

        FileParser<TextFile> fileParser = new TextFileParser();
        TextFile textFile = fileParser.parse(url);

        FileAnalyzer<TextFile> textAnalyzer = new TextFileAnalyzer();
        textAnalyzer.analyze(textFile);

        ReportGenerator<TextFile> reportGenerator = new TextFileReportGenerator();
        System.out.println(reportGenerator.generate(textFile));
    }
}
