
import java.util.ArrayDeque;
import java.util.Deque;

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
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Every close bracket has a corresponding open
 * bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 *
 * @author miguel
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character r = stack.removeFirst();
                if (r == null
                        || c == ')' && r != '('
                        || c == ']' && r != '['
                        || c == '}' && r != '{') {
                    return false;
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;

    }

}
