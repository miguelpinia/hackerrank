
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]] Example 2:
 *
 * Input: root = [1] Output: [[1]] Example 3:
 *
 * Input: root = [] Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val
 * <= 1000
 *
 * @author miguel
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level = queue.size();
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode t = queue.removeFirst();
                numbers.add(t.val);
                if (t.left != null) {
                    queue.addLast(t.left);
                }
                if (t.right != null) {
                    queue.addLast(t.right);
                }
            }
            result.add(numbers);
        }
        return result;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
