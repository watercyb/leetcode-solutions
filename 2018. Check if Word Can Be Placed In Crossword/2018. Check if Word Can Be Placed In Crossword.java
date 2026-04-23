/*
 * Problem: 2018. Check if Word Can Be Placed In Crossword
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] chrs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board.length - i >= chrs.length && (i == 0 || board[i - 1][j] == '#')) {
                    int k = 0;
                    for (k = 0; k < chrs.length; k++) {
                        if (board[i + k][j] != ' ' && board[i + k][j] != chrs[k])
                            break;
                    }
                    if (k == chrs.length && (i + k == board.length || board[i + k][j] == '#'))
                        return true;
                    for (k = 0; k < chrs.length; k++) {
                        if (board[i + k][j] != ' ' && board[i + k][j] != chrs[chrs.length - 1 - k])
                            break;
                    }
                    if (k == chrs.length && (i + k == board.length || board[i + k][j] == '#'))
                        return true;
                }
                if (board[0].length - j >= chrs.length && (j == 0 || board[i][j - 1] == '#')) {
                    int k = 0;
                    for (k = 0; k < chrs.length; k++) {
                        if (board[i][j + k] != ' ' && board[i][j + k] != chrs[k])
                            break;
                    }
                    if (k == chrs.length && (j + k == board[0].length || board[i][j + k] == '#'))
                        return true;
                    for (k = 0; k < chrs.length; k++) {
                        if (board[i][j + k] != ' ' && board[i][j + k] != chrs[chrs.length - 1 - k])
                            break;
                    }
                    if (k == chrs.length && (j + k == board[0].length || board[i][j + k] == '#'))
                        return true;
                }
            }
        }
        return false;
    }
}
