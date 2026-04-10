/*
 * Problem: 948. Bag of Tokens
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bag-of-tokens/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int res = 0;
        int score = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                res = Math.max(res, score);
                i++;
            } else if (score > 0) {
                power += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }
        return res;
    }
}
