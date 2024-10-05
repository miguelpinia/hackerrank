
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
 * 105. Construct Binary Tree from Preorder and Inorder Traversal Solved Medium
 *
 * Topics Array Hash Table Divide and Conquer Tree Binary Tree
 *
 * Companies Given two integer arrays preorder and inorder where preorder is the
 * preorder traversal of a binary tree and inorder is the inorder traversal of
 * the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] Output:
 * [3,9,20,null,null,15,7] Example 2:
 *
 * Input: preorder = [-1], inorder = [-1] Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000 inorder.length == preorder.length -3000 <=
 * preorder[i], inorder[i] <= 3000 preorder and inorder consist of unique
 * values. Each value of inorder also appears in preorder. preorder is
 * guaranteed to be the preorder traversal of the tree. inorder is guaranteed to
 * be the inorder traversal of the tree.
 *
 *
 * @author miguel
 */
public class ConstructBinaryTreeFromPreorderInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder array
        // inorder array

        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }
        TreeNode root = null;
        TreeNode current = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int p : preorder) {
            if (root == null) {
                root = new TreeNode(p);
                current = root;
            } else if (indexes.get(p) < indexes.get(current.val)) {
                stack.addFirst(current);
                current.left = new TreeNode(p);
                current = current.left;
            } else {
                while (!stack.isEmpty() && indexes.get(stack.peek().val) < indexes.get(p)) {
                    current = stack.removeFirst();
                }
                current.right = new TreeNode(p);
                current = current.right;
            }
        }
        return root;
    }

}
