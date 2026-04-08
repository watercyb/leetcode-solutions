#
# Problem: 794. Valid Tic-Tac-Toe State
# Difficulty: Medium
# Link: https://leetcode.com/problems/valid-tic-tac-toe-state/
# Language: python3
# Date: 2026-04-08


class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        count_o = 0
        count_x = 0
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == "O":
                    count_o += 1
                elif board[i][j] == "X":
                    count_x += 1
        if count_o > count_x or count_o + 1 < count_x:
            return False
        count_o_3 = 0
        count_x_3 = 0
        if board[0][0] == board[1][0] and board[1][0] == board[2][0]:
            if board[0][0] == "O":
                count_o_3 += 1
            elif board[0][0] == "X":
                count_x_3 += 1
        if board[0][1] == board[1][1] and board[1][1] == board[2][1]:
            if board[0][1] == "O":
                count_o_3 += 1
            elif board[0][1] == "X":
                count_x_3 += 1
        if board[0][2] == board[1][2] and board[1][2] == board[2][2]:
            if board[0][2] == "O":
                count_o_3 += 1
            elif board[0][2] == "X":
                count_x_3 += 1
        if board[0] == "OOO":
            count_o_3 += 1
        elif board[0] == "XXX":
            count_x_3 += 1
        if board[1] == "OOO":
            count_o_3 += 1
        elif board[1] == "XXX":
            count_x_3 += 1
        if board[2] == "OOO":
            count_o_3 += 1
        elif board[2] == "XXX":
            count_x_3 += 1
        if board[0][0] == board[1][1] and board[1][1] == board[2][2]:
            if board[0][0] == "O":
                count_o_3 += 1
            elif board[0][0] == "X":
                count_x_3 += 1
        if board[0][2] == board[1][1] and board[1][1] == board[2][0]:
            if board[0][2] == "O":
                count_o_3 += 1
            elif board[0][2] == "X":
                count_x_3 += 1
        if count_o_3 > 0 and count_x_3 > 0:
            return False
        if count_o_3 > 0:
            return count_o == count_x
        if count_x_3 > 0:
            return count_o + 1 == count_x
        return True

