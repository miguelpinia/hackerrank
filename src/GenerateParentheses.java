
import java.util.ArrayList;
import java.util.List;

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
 * 22. Generate Parentheses Solved Medium
 *
 * Topics String Dynamic Programming Backtracking
 *
 * Companies Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"] Example
 * 2:
 *
 * Input: n = 1 Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 * @author miguel
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        // For each generated string, we need to check if such string is valid
        // So, we will define a function that validates an string
        // Using dfs with backtracking, we will generate all possible strings
        // Due to constraints,
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, 0, 0, n);
        return result;
    }

    private void dfs(List<String> generated, StringBuilder sb, int openP, int closedP, int size) {
        if (openP == size && closedP == size) {
            generated.add(sb.toString());
            return;
        }
        if (openP < size) {
            sb.append('(');
            dfs(generated, sb, openP + 1, closedP, size);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (closedP < openP) {
            sb.append(')');
            dfs(generated, sb, openP, closedP + 1, size);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

}
