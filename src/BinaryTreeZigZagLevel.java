
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
 * 103. Binary Tree Zigzag Level Order Traversal Solved Medium
 *
 * Topics Tree Breadth-First Search Binary Tree
 *
 *
 * Companies Given the root of a binary tree, return the zigzag level order
 * traversal of its nodes' values. (i.e., from left to right, then right to left
 * for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]] Example 2:
 *
 * Input: root = [1] Output: [[1]] Example 3:
 *
 * Input: root = [] Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000]. -100 <= Node.val
 * <= 100
 *
 *
 * @author miguel
 */
public class BinaryTreeZigZagLevel {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZag = new ArrayList<>();
        if (root == null) {
            return zigZag;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int level;
        boolean right = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            level = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            Deque<Integer> toAdd = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                TreeNode t = queue.removeFirst();
                toAdd.addLast(t.val);
                if (t.left != null) {
                    queue.addLast(t.left);
                }
                if (t.right != null) {
                    queue.addLast(t.right);
                }
            }
            while (!toAdd.isEmpty()) {
                if (right) {
                    currentLevel.add(toAdd.removeLast());
                } else {
                    currentLevel.add(toAdd.removeFirst());
                }
            }
            zigZag.add(currentLevel);
            right = !right;
        }
        return zigZag;
    }

    public class TreeNode {

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
