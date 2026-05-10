/*
 * Problem: 3706. Maximum Distance Between Unequal Words in Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-distance-between-unequal-words-in-array-ii/
 * Language: java
 * Date: 2026-05-10
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
        if (res == 0)
            return res;
        for (int i = words.length - 1; i > res - 1; i--) {
            if (!words[i].equals(words[0])) {
                res = Math.max(res, i + 1);
                break;
            }
        }
        return res;
    }
}
