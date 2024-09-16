package leetcode;

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
 * 98. Validate Binary Search Tree
 *
 * Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3] Output: true Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6] Output: false Explanation: The root
 * node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104]. -231 <= Node.val <=
 * 231 - 1
 *
 * @author miguel
 */
public class IsValidBST {

    private boolean isValid(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (!(left < root.val && root.val < right)) {
            return false;
        }
        return isValid(root.left, left, root.val) && isValid(root.right, root.val, right);
    }

    /*¨**
     * 0ms, beats 100%, 43.52mb, beats 47.09%.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        long prev = Long.MIN_VALUE;
        long next = Long.MAX_VALUE;
        return isValid(root, prev, next);
    }

    /**
     * 1ms, beats 23.73%, 43.58mb, beats 47.09%.
     *
     * @param root
     * @return
     */
    public boolean isValidBSTIterative(TreeNode root) {
        long prev = Long.MIN_VALUE;
        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            if (current != null) {
                stack.addFirst(current);
                current = current.left;
            } else if (!stack.isEmpty()) {
                current = stack.removeFirst();
                if (prev >= current.val) {
                    return false;
                }
                prev = current.val;
                current = current.right;
            } else {
                break;
            }
        }
        return true;
    }

}
