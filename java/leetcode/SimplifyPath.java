
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
 * 71. Simplify Path
 *
 * You are given an absolute path for a Unix-style file system, which always
 * begins with a slash '/'. Your task is to transform this absolute path into
 * its simplified canonical path.
 *
 * The rules of a Unix-style file system are as follows:
 *
 * A single period '.' represents the current directory. A double period '..'
 * represents the previous/parent directory. Multiple consecutive slashes such
 * as '//' and '///' are treated as a single slash '/'. Any sequence of periods
 * that does not match the rules above should be treated as a valid directory or
 * file name. For example, '...' and '....' are valid directory or file names.
 * The simplified canonical path should follow these rules:
 *
 * The path must start with a single slash '/'. Directories within the path must
 * be separated by exactly one slash '/'. The path must not end with a slash
 * '/', unless it is the root directory. The path must not have any single or
 * double periods ('.' and '..') used to denote current or parent directories.
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 *
 * Output: "/home"
 *
 * Explanation:
 *
 * The trailing slash should be removed.
 *
 * Example 2:
 *
 * Input: path = "/home//foo/"
 *
 * Output: "/home/foo"
 *
 * Explanation:
 *
 * Multiple consecutive slashes are replaced by a single one.
 *
 * Example 3:
 *
 * Input: path = "/home/user/Documents/../Pictures"
 *
 * Output: "/home/user/Pictures"
 *
 * Explanation:
 *
 * A double period ".." refers to the directory up a level (the parent
 * directory).
 *
 * Example 4:
 *
 * Input: path = "/../"
 *
 * Output: "/"
 *
 * Explanation:
 *
 * Going one level up from the root directory is not possible.
 *
 * Example 5:
 *
 * Input: path = "/.../a/../b/c/../d/./"
 *
 * Output: "/.../b/d"
 *
 * Explanation:
 *
 * "..." is a valid name for a directory in this problem.
 *
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000 path consists of English letters, digits, period
 * '.', slash '/' or '_'. path is a valid absolute Unix path.
 *
 *
 * @author miguel
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        char[] chars = (path + "/").toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '/') {
                if (sb.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    }
                } else if (!sb.isEmpty() && !sb.toString().equals(".")) {
                    stack.addLast(sb.toString());
                }
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        return "/" + String.join("/", stack);
    }

    public String simplifyPath2(String path) {
        StringBuilder sb = new StringBuilder();

        for (String s : path.split("/")) {
            if (s.equals("..") && !sb.isEmpty()) {
                sb.delete(sb.lastIndexOf("/"), sb.length());
            } else if (!s.equals(".") && !s.equals("..") && !s.isEmpty()) {
                sb.append("/").append(s);
            }
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}
