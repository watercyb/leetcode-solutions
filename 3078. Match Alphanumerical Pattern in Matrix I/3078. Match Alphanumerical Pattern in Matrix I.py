#
# Problem: 3078. Match Alphanumerical Pattern in Matrix I
# Difficulty: Medium
# Link: https://leetcode.com/problems/match-alphanumerical-pattern-in-matrix-i/
# Language: python3
# Date: 2026-05-03


class Solution:
    def findPattern(self, board: List[List[int]], pattern: List[str]) -> List[int]:
        def chk(x: int, y: int) -> bool:
            mp = {}
            st = set()
            for i in range(len(pattern)):
                for j in range(len(pattern[0])):
                    digit = board[x + i][y + j]
                    idx = ord(pattern[i][j]) - ord("0")
                    if idx <= 9:
                        if digit != idx:
                            return False
                    else:
                        if idx in mp:
                            if mp[idx] != digit:
                                return False
                        else:
                            if digit in st:
                                return False
                            mp[idx] = digit
                            st.add(digit)
            return True

        for i in range(len(board) - len(pattern) + 1):
            for j in range(len(board[0]) - len(pattern[0]) + 1):
                if chk(i, j):
                    return [i, j]
        return [-1, -1]

