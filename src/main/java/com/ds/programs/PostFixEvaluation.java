
package com.ds.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

/**
 * Program to do post fix evaluation on mathematical expression
 */
public class PostFixEvaluation {

    /**
     * Given a space delimited postfix expression string, evaluate the same.
     * @param expression a valid space delimited postfix expression.
     * @return output of the evaluation
     */
    public static Double solution(String expression) {
        String[] postfix = expression.split(" ");
        Stack<Double> operators = new Stack<>();
        for (String s : postfix) {
            if (Operands.isValidOperand(s)) {
                Double op2 = operators.pop();
                Double op1 = operators.pop();
                operators.push(Operands.valueOf(s.toCharArray()[0])
                                       .apply(op1, op2));
            } else {
                operators.push(Double.valueOf(s));
            }
        }
        System.out.println("= "+operators.peek());
        return operators.pop();
    }

    @RequiredArgsConstructor
    static enum Operands {

        ADD('+', (i, j) -> Double.valueOf(i + j)),
        SUBTRACT('-', (i, j) -> Double.valueOf(i - j)),
        MULTIPLY('*', (i, j) -> Double.valueOf(i * j)),
        DIVIDE('/', (i, j) -> Double.valueOf(i / j)),
        EXPONENT('^', (i, j) -> Double.valueOf(i.intValue() ^ j.intValue()));

        private final char operand;

        private final BiFunction<Double, Double, Double> func;

        private static final Map<Character, Operands> operandsMap = Arrays.stream(Operands.values())
                                                                          .collect(Collectors.toMap(operands -> operands.operand, Function.identity()));

        public Double apply(double i, double j) {
            System.out.println(String.format(">> %s %s %s", i, operand, j));
            return func.apply(i, j);
        }

        public static Operands valueOf(char c) {
            return operandsMap.get(c);
        }

        public static boolean isValidOperand(String s) {
            return operandsMap.containsKey(s.toCharArray()[0]);
        }
    }

}
