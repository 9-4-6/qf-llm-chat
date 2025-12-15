package org.gz.qfllmchat;

import dev.langchain4j.agent.tool.Tool;

public class Calculator {
    @Tool
    double add(int a, int b) {
        return a + b;
    }

    @Tool
    double squareRoot(double x) {
        return Math.sqrt(x);
    }
}
