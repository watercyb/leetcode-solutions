/*
 * Problem: 3696. Maximum Distance Between Unequal Words in Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-distance-between-unequal-words-in-array-i/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int maxDistance(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(words[words.length - 1])) {
                res = words.length - i;
                break;
            }
        }
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[0].equals(words[i])) {
                res = Math.max(res, i + 1);
                break;
            }
        }
        return res;
    }
}
