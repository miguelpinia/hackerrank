
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
 *
 *  * 199. Binary Tree Right Side View
 *
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4] Output: [1,3,4] Example 2:
 *
 * Input: root = [1,null,3] Output: [1,3] Example 3:
 *
 * Input: root = [] Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <=
 * 100
 *
 *
 *
 * @author miguel
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode t = queue.removeFirst();
                if (i == level - 1) {
                    result.add(t.val);
                }
                if (t.left != null) {
                    queue.addLast(t.left);
                }
                if (t.right != null) {
                    queue.addLast(t.right);
                }
            }
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
