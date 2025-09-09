package org.technical;


import org.technical.core.calculator.VisitorBasedCalculator;
import org.technical.driver.Repl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Repl repl = new Repl(
                new InputStreamReader(System.in),
                new VisitorBasedCalculator(),
                new PrintWriter(System.out)
        );
        repl.start();
    }
}
