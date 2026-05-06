#
# Problem: 3391. Design a 3D Binary Matrix with Efficient Layer Tracking
# Difficulty: Medium
# Link: https://leetcode.com/problems/design-a-3d-binary-matrix-with-efficient-layer-tracking/
# Language: python3
# Date: 2026-05-06


class Matrix3D:

    def __init__(self, n: int):
        self.matrix: List[List[List[int]]] = [
            [[0] * n for _ in range(n)] for _ in range(n)
        ]
        self.counts: List[int] = [0] * n

    def setCell(self, x: int, y: int, z: int) -> None:
        if self.matrix[x][y][z] == 0:
            self.matrix[x][y][z] = 1
            self.counts[x] += 1

    def unsetCell(self, x: int, y: int, z: int) -> None:
        if self.matrix[x][y][z] == 1:
            self.matrix[x][y][z] = 0
            self.counts[x] -= 1

    def largestMatrix(self) -> int:
        res = 0
        for i in range(len(self.counts)):
            if self.counts[i] >= self.counts[res]:
                res = i
        return res


# Your Matrix3D object will be instantiated and called as such:
# obj = Matrix3D(n)
# obj.setCell(x,y,z)
# obj.unsetCell(x,y,z)
# param_3 = obj.largestMatrix()

