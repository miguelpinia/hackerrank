
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
 *
 * 530. Minimum Absolute Difference in BST
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute
 * difference between the values of any two different nodes in the tree. Example
 * 1:
 *
 *
 * Input: root = [4,2,6,1,3] Output: 1 Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49] Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 104]. 0 <= Node.val <=
 * 105
 *
 *
 * @author miguel
 */
public class MinimumAbsoluteDifferenceInBST {

    /**
     * 0ms, beats 100%. 40.80MB, beats 96.38%.
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode prev = null;
        int result = Integer.MAX_VALUE;
        while (true) {
            if (current != null) {
                stack.addFirst(current);
                current = current.left;
            } else if (!stack.isEmpty()) {
                current = stack.removeFirst();
                if (prev != null) {
                    result = Math.min(result, current.val - prev.val);
                }
                prev = current;
                current = current.right;
            } else {
                break;
            }
        }
        return result;
    }

}
