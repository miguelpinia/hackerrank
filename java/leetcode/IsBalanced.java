package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 *
 * @author miguel
 */
public class IsBalanced {

    private static boolean isExpectedInStackTop(char c, Stack<Character> s) {
        if (s.isEmpty()) {
            return false;
        }
        return s.pop() == c;
    }

    public static String isBalanced(String s) {
        // Write your code here}
        if (s.length() == 1) {
            return "NO";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{' ->
                    stack.push('}');
                case '[' ->
                    stack.push(']');
                case '(' ->
                    stack.push(')');
                case '}' -> {
                    if (!isExpectedInStackTop('}', stack)) {
                        return "NO";
                    }
                }
                case ']' -> {
                    if (!isExpectedInStackTop(']', stack)) {
                        return "NO";
                    }
                }
                case ')' -> {
                    if (!isExpectedInStackTop(')', stack)) {
                        return "NO";
                    }
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    String s = bufferedReader.readLine();

                    String result = isBalanced(s);
                    System.out.println(result);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

}
