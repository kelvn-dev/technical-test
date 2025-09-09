package org.technical.core.calculator;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.technical.CalculatorLexer;
import org.technical.CalculatorParser;
import org.technical.core.evaluator.CalculationVisitor;

public class VisitorBasedCalculator implements Calculator {
    @Override
    public Double calculate(String input) {
        CharStream chars = CharStreams.fromString(input);

        Lexer lexer = new CalculatorLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.start();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        CalculationVisitor calculator = new CalculationVisitor();
        return calculator.visit(tree);
    }
}
