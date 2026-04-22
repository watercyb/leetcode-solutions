#
# Problem: 1958. Check if Move is Legal
# Difficulty: Medium
# Link: https://leetcode.com/problems/check-if-move-is-legal/
# Language: python3
# Date: 2026-04-22


class Solution:
    def checkMove(
        self, board: List[List[str]], rMove: int, cMove: int, color: str
    ) -> bool:
        r = len(board)
        c = len(board[0])
        op = "W" if color == "B" else "B"
        if rMove >= 2:
            idx = rMove - 1
            while idx >= 0 and board[idx][cMove] == op:
                idx -= 1
            if idx >= 0 and idx <= rMove - 2 and board[idx][cMove] == color:
                return True
        if rMove <= r - 3:
            idx = rMove + 1
            while idx < r and board[idx][cMove] == op:
                idx += 1
            if idx < r and idx >= rMove + 2 and board[idx][cMove] == color:
                return True
        if cMove >= 2:
            idx = cMove - 1
            while idx >= 0 and board[rMove][idx] == op:
                idx -= 1
            if idx >= 0 and idx <= cMove - 2 and board[rMove][idx] == color:
                return True
        if cMove <= c - 3:
            idx = cMove + 1
            while idx < c and board[rMove][idx] == op:
                idx += 1
            if idx < c and idx >= cMove + 2 and board[rMove][idx] == color:
                return True
        if rMove >= 2 and cMove >= 2:
            x = rMove - 1
            y = cMove - 1
            while x >= 0 and y >= 0 and board[x][y] == op:
                x -= 1
                y -= 1
            if x >= 0 and y >= 0 and x <= rMove - 2 and board[x][y] == color:
                return True
        if rMove >= 2 and cMove <= c - 3:
            x = rMove - 1
            y = cMove + 1
            while x >= 0 and y < c and board[x][y] == op:
                x -= 1
                y += 1
            if x >= 0 and y < c and x <= rMove - 2 and board[x][y] == color:
                return True
        if rMove <= r - 3 and cMove >= 2:
            x = rMove + 1
            y = cMove - 1
            while x < r and y >= 0 and board[x][y] == op:
                x += 1
                y -= 1
            if x < r and y >= 0 and x >= rMove + 2 and board[x][y] == color:
                return True
        if rMove <= r - 3 and cMove <= c - 3:
            x = rMove + 1
            y = cMove + 1
            while x < r and y < c and board[x][y] == op:
                x += 1
                y += 1
            if x < r and y < c and x >= rMove + 2 and board[x][y] == color:
                return True
        return False

