/*
 * Problem: 2268. Minimum Number of Keypresses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-keypresses/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int minimumKeypresses(String s) {
        int[] counts = new int[26];
        for (char chr : s.toCharArray()) {
            counts[chr - 'a']++;
        }
        Arrays.sort(counts);
        int res = 0;
        int press = 1;
        int count = 0;
        for (int i = 25; i >= 0; i--) {
            res += counts[i] * press;
            count++;
            if (count == 9) {
                press++;
                count = 0;
            }
        }
        return res;
    }
}
