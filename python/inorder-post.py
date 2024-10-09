from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        if self.val == 0: return ""
        return str(self.left) + " " + str(self.val) + " " + str(self.right)

class Solution:
    # def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
    #     if not postorder or not inorder: return None
    #     if (root is None):
    #         postorder = list(reversed(postorder))
    #         root = TreeNode(postorder[0])

    #     middle = inorder.index(postorder[0])
    #     # print("Middle: ", middle, inorder[1:middle])
    #     root.left = self.buildTree(postorder[1:middle + 1], inorder[:middle])
    #     root.right = self.buildTree(postorder[middle + 1:], inorder[middle+1:])
    #     return root
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        indexes = {value: index for index, value in enumerate(inorder)}
        def helper(l, r):
            if l > r: return None
            root = TreeNode(postorder.pop())
            mid = indexes[root.val]
            root.right = helper(mid + 1, r)
            root.left = helper(l, mid - 1)
            return root
        return helper(0, len(inorder) - 1)

s = Solution()

a = [9,15,7,20,3]
b = [9,3,15,20,7]

print(s.buildTree(b, a))
