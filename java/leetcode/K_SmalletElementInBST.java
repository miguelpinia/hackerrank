package leetcode;

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
 * @author miguel
 */
public class K_SmalletElementInBST {

    /**
     * 0ms, beats 100%, 44.20MB, beats 76.34%.¨*
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque();
        int i = 0;
        TreeNode current = root;

        while (true) {
            if (current != null) {
                stack.addFirst(current);
                current = current.left;
            } else if (!stack.isEmpty()) {
                current = stack.removeFirst();
                i++;
                if (i == k) {
                    return current.val;
                }
                current = current.right;
            } else {
                break;
            }
        }
        return 0;
    }

    private int counter = 0;
    private int result = -1; // ugly solution, not self-contained.

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        counter++;
        if (counter == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }

    /**
     * 0ms, beats 100%, 43.96mb beats 93.36%.
     *
     * More space efficient but I feel it ugly.
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestRecursive(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

}
