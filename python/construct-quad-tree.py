class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':
        def dfs(size, row, col):
            allEquals = True
            for i in range(size):
                for j in range(size):
                    if grid[row][col] != grid[row + i][col + j]:
                        allEquals = False
                        break
            if allEquals:
                return Node(grid[row][col], True)
            size //= 2
            tl = dfs(size, row, col)
            tr = dfs(size, row, col + size)
            bl = dfs(size, row + size, col)
            br = dfs(size, row + size, col + size)
            return Node(0, False, tl, tr, bl, br)
        return dfs(len(grid), 0, 0)
