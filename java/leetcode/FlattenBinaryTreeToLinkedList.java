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
 * @author miguel
 */
public class FlattenBinaryTreeToLinkedList {

    private TreeNode mostRight(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null && root.right == null) {
            return mostRight(root.left);
        }
        return mostRight(root.right);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                current = current.right;
                continue;
            }
            TreeNode left = current.left;
            TreeNode mr = mostRight(left);
            mr.right = current.right;
            current.right = left;
            current.left = null;
            current = current.right;
        }
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
