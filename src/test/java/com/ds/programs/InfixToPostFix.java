
package com.ds.programs;

import java.util.Stack;
import java.util.StringJoiner;

import com.ds.programs.PostFixEvaluation.Operator;

/**
 * Program to convert Infix expression into PostFix expression
 */
public class InfixToPostFix {

    /**
     * Converts the given infix expression into post fix expression.
     * @param infix valid space delimited String representing an infix expression
     * @return equivalent post fix expression
     */
    public static String convert(String infix) {
        StringJoiner postFix = new StringJoiner(" ");
        Stack<Operator> operators = new Stack<>();
        String[] infixExpr = infix.split(" ");
        for (String s : infixExpr) {
            if (!Operator.isValidOperator(s))
                postFix.add(s);
            else {
                if (operators.isEmpty() || Operator.valueOf(s.toCharArray()[0])
                                                   .compareWith(operators.peek()) > 0)
                    operators.push(Operator.valueOf(s.toCharArray()[0]));
                else {
                    while (!operators.isEmpty() && Operator.valueOf(s.toCharArray()[0])
                                                           .compareWith(operators.peek()) <= 0) {
                        postFix.add(String.valueOf(operators.pop()
                                                            .getOperator()));
                    }
                    operators.push(Operator.valueOf(s.toCharArray()[0]));
                }
            }
        }
        while (!operators.isEmpty())
            postFix.add(String.valueOf(operators.pop()
                                                .getOperator()));
        return postFix.toString();
    }
}
