/*
 * Problem: 953. Verifying an Alien Dictionary
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/verifying-an-alien-dictionary/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int['z' + 1];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i)] = i;
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i - 1].length(); j++) {
                if (j == words[i].length() || orders[words[i].charAt(j)] < orders[words[i - 1].charAt(j)]) {
                    return false;
                } else if (orders[words[i].charAt(j)] > orders[words[i - 1].charAt(j)]) {
                    break;
                }
            }
        }
        return true;
    }
}
