/*
 * Problem: 1165. Single-Row Keyboard
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/single-row-keyboard/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] idx = new int['z' + 1];
        for (int i = 0; i < keyboard.length(); i++) {
            idx[keyboard.charAt(i)] = i;
        }
        int prv = 0;
        int res = 0;
        for (char chr : word.toCharArray()) {
            res += Math.abs(idx[chr] - prv);
            prv = idx[chr];
        }
        return res;
    }
}
