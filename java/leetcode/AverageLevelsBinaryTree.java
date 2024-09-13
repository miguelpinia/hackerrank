
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
 * 637. Average of Levels in Binary Tree
 *
 * Given the root of a binary tree, return the average value of the nodes on
 * each level in the form of an array. Answers within 10-5 of the actual answer
 * will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7] Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11. Hence return [3, 14.5, 11]. Example 2:
 *
 *
 * Input: root = [3,9,20,15,7] Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104]. -231 <= Node.val <=
 * 231 - 1
 *
 * @author miguel
 */
public class AverageLevelsBinaryTree {

    /**
     * 2ms, beats 95.12%, 45.49mb, beats, 78.38%
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        int level = 0;
        double levelSum;
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            level = queue.size();
            levelSum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode t = queue.removeFirst();
                levelSum += t.val;
                if (t.left != null) {
                    queue.addLast(t.left);
                }
                if (t.right != null) {
                    queue.addLast(t.right);
                }
            }
            result.add(levelSum / level);
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
