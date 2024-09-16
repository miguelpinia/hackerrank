
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
 * 226. Invert Binary Tree
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9] Output: [4,7,2,9,6,3,1] Example 2:
 *
 *
 * Input: root = [2,1,3] Output: [2,3,1] Example 3:
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
 * @author miguel
 */
public class InvertBinaryTree {

    /**
     * 0ms beats 100%, 41.52mb, beats 9.42
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        TreeNode tmp, s;
        while (!queue.isEmpty()) {
            s = queue.removeFirst();
            tmp = s.left;
            s.left = s.right;
            s.right = tmp;
            if (s.left != null) {
                queue.addLast(s.left);
            }
            if (s.right != null) {
                queue.addLast(s.right);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
