class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        if self.val == 0: return ""
        return str(self.left) + " " + str(self.val) + " " + str(self.right)


def build(preorder, inorder):
    if not preorder or not inorder:
        return None
    root = TreeNode(preorder[0])
    mid = inorder.index(preorder[0])
    root.left = build(preorder[1:mid + 1], inorder[:mid])
    root.right = build(preorder[mid + 1:], inorder[mid + 1:])
    return root

def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        loc = {x : i for i, x in enumerate(inorder)}
        root = None
        stack = []
        for x in preorder:
            if not root: root = node = TreeNode(x)
            elif loc[x] < loc[node.val]:
                stack.append(node)
                node.left = node = TreeNode(x)
            else:
                while stack and loc[stack[-1].val] < loc[x]: node = stack.pop() # backtracking
                node.right = node = TreeNode(x)
        return root

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: return None
        root = TreeNode(preorder[0])
        middle = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:middle + 1], inorder[:middle])
        root.right = self.buildTree(preorder[middle + 1:], inorder[middle + 1:])
        return root

# a = [4,5,3,17,2,6,7,1,9,8,10,11,13,14,15,20,19]
# b = [3,2,6,17,1,7,5,9,8,4,10,14,13,11,20,15,19]
a = [1,2,4,6,5,3,7,8,9,10]
b = [4,2,5,6,1,3,8,9,7,10]
# a = [3,9,20,15,7]
# b = [9,3,15,20,7]


# a.sort()
# b.sort()
# print(a)
# print(b)

x = build(a, b)
print(x)
