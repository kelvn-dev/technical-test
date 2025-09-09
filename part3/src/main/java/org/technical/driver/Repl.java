package org.technical.driver;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.technical.CalculatorLexer;
import org.technical.CalculatorParser;
import org.technical.core.calculator.Calculator;
import org.technical.core.evaluator.CalculationVisitor;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

/**
 * A REPL (read-evaluate-print-loop) is a continuously running program which:
 *
 * 1. reads input
 * 2. evaluates the input
 * 3. prints the result of the evaluation
 */
public class Repl {
    private final Scanner scanner;
    private final Calculator calculator;
    private final Writer output;

    public Repl(Reader input, Calculator calculator, Writer output) {
        this.scanner = new Scanner(input);
        this.calculator = calculator;
        this.output = output;
    }

    public void start() throws IOException {
        while (true) {
            this.write("Calculate:\n");
            String line = this.scanner.nextLine();

            if (line.equalsIgnoreCase("exit") || line.isEmpty()) {
                this.writeLine("Goodbye");
                break;
            }

            try {
                Double result = this.calculator.calculate(line);
                this.writeLine(result.toString());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void write(String message) throws IOException {
        this.output.write(message);
        this.output.flush();
    }

    private void writeLine(String line) throws IOException {
        this.write(line + "\n");
    }
}
