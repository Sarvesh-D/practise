package com.ds.codility;

import java.util.Stack;

/**
 * @author Sarvesh Dubey
 *
 */
public class Brackets {

    /**
     * Given a string consisting of brackets <b>[, ], {, }, (, )<b>, returns if the
     * string is valid or not.<br>
     * A string is considered to be valid <b>iff<b> the bracket that is opened last
     * is closed first. <br>
     * Example: [{}()[()]] is a valid string, while [{] is not.
     * 
     * @param S
     *            string to be validated
     * @return boolean <code>true<code> if the string is valid <code>false<code>
     *         otherwise.
     */
    public static boolean isValid(String S) {
        char[] brackets = S.toCharArray();
        if (brackets.length == 0)
            return true;
        if (brackets.length % 2 != 0 || stringStartsWithClosingBracket(brackets))
            return false;
        Stack<Character> openBrackets = new Stack<>();
        boolean isValid = false;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '[' || brackets[i] == '(' || brackets[i] == '{')
                openBrackets.push(brackets[i]);
            else if (openBrackets.isEmpty() || !isBalanced(openBrackets.pop(), brackets[i]))
                return false;
        }
        if (openBrackets.isEmpty())
            return true;
        return isValid;
    }

    private static boolean stringStartsWithClosingBracket(char[] brackets) {
        return brackets[0] == ']' || brackets[0] == ')' || brackets[0] == '}';
    }

    private static boolean isBalanced(char l, char r) {
        return ((l == '[' && r == ']') || (l == '{' && r == '}') || (l == '(' && r == ')'));
    }

}
