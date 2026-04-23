/*
 * Problem: 2005. Subtree Removal Game with Fibonacci Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subtree-removal-game-with-fibonacci-tree/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean findGameWinner(int n) {
        if (n == 1)
            return false;
        if (n == 2)
            return true;
        int a = 0;
        int b = 1;
        n -= 2;
        int xor = 0;
        while (n > 0) {
            xor = (a + 1) ^ (b + 1);
            a = b;
            b = xor;
            n--;
        }
        return xor != 0;
    }
}
