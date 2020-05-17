
package com.ds.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Getter;
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
            if (Operator.isValidOperator(s)) {
                Double op2 = operators.pop();
                Double op1 = operators.pop();
                operators.push(Operator.valueOf(s.toCharArray()[0])
                                       .apply(op1, op2));
            } else {
                operators.push(Double.valueOf(s));
            }
        }
        System.out.println("= " + operators.peek());
        return operators.pop();
    }

    @RequiredArgsConstructor
    static enum Operator {

        EXPONENT('^', (i, j) -> Double.valueOf(i.intValue() ^ j.intValue())),
        MULTIPLY('*', (i, j) -> Double.valueOf(i * j)),
        DIVIDE('/', (i, j) -> Double.valueOf(i / j)),
        ADD('+', (i, j) -> Double.valueOf(i + j)),
        SUBTRACT('-', (i, j) -> Double.valueOf(i - j));

        @Getter
        private final char operator;

        private final BiFunction<Double, Double, Double> func;

        private static final Map<Character, Operator> operatorsMap = Arrays.stream(Operator.values())
                                                                           .collect(Collectors.toMap(operands -> operands.operator, Function.identity()));

        public Double apply(double i, double j) {
            System.out.println(String.format(">> %s %s %s", i, operator, j));
            return func.apply(i, j);
        }

        public static Operator valueOf(char c) {
            return operatorsMap.get(c);
        }

        public static boolean isValidOperator(String s) {
            return operatorsMap.containsKey(s.toCharArray()[0]);
        }

        public int compareWith(Operator o) {
            return Integer.compare(o.ordinal(), this.ordinal());
        }

    }

}
