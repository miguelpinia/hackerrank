
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
 * Copyright (c) 2024 miguel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    miguel - initial API and implementation and/or initial documentation
 */
/**
 * 150. Evaluate Reverse Polish Notation
 *
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'. Each operand may be an
 * integer or another expression. The division between two integers always
 * truncates toward zero. There will not be any division by zero. The input
 * represents a valid arithmetic expression in a reverse polish notation. The
 * answer and all the intermediate calculations can be represented in a 32-bit
 * integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) =
 * 9 Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5))
 * = 6 Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22 Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 /
 * (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104 tokens[i] is either an operator: "+", "-", "*", or
 * "/", or an integer in the range [-200, 200].
 *
 * @author miguel
 */
public class EvaluateReversePolishNotation {

    private int evaluation(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Deque<Integer> values = new ArrayDeque<>();
        Set<String> operations = new HashSet<>();
        operations.add("*");
        operations.add("-");
        operations.add("+");
        operations.add("/");
        int result = Integer.MIN_VALUE;
        for (String token : tokens) {
            if (operations.contains(token)) {
                int a = values.removeFirst();
                int b = values.removeFirst();
                result = evaluation(b, a, token);
                values.addFirst(result);
            } else {
                values.addFirst(Integer.valueOf(token));
            }
        }
        return result;
    }

}
