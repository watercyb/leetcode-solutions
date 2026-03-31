/*
 * Problem: 293. Flip Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/flip-game/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        char[] chrs = currentState.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chrs.length - 1; i++) {
            if (chrs[i] == '+' && chrs[i + 1] == '+') {
                chrs[i] = '-';
                chrs[i + 1] = '-';
                res.add(new String(chrs));
                chrs[i] = '+';
                chrs[i + 1] = '+';
            }
        }
        return res;
    }
}
