/*
 * Problem: 318. Maximum Product of Word Lengths
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-of-word-lengths/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] nums = new int[n];
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            int h = 0;
            for (char chr : words[i].toCharArray()) {
                h |= 1 << (chr - 'a');
            }
            nums[i] = h;
            lens[i] = words[i].length();
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] & nums[j]) == 0)
                    res = Math.max(res, lens[i] * lens[j]);
            }
        }
        return res;
    }
}
