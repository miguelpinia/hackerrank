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
 * 101. Symmetric Tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 * @author miguel
 */
public class SymmetricTree {

    private boolean symmetricDFS(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val
                && symmetricDFS(left.left, right.right)
                && symmetricDFS(right.left, left.right);
    }

    /**
     * 0ms, beats 100%, 41.61MB, beats 55.19%
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return symmetricDFS(root.left, root.right);
    }

}
