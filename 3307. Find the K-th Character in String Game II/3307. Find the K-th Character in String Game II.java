/*
 * Problem: 3307. Find the K-th Character in String Game II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public char kthCharacter(long k, int[] operations) {
        double total = Math.pow(2, operations.length);
        int count = 0;
        for (int i = operations.length - 1; i >= 0; i--) {
            total /= 2;
            if (k > total) {
                k -= total;
                if (operations[i] == 1)
                    count++;
            }
        }
        count %= 26;
        return (char) ('a' + count);
    }
}
