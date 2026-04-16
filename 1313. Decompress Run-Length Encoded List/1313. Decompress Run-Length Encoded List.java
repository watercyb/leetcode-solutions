/*
 * Problem: 1313. Decompress Run-Length Encoded List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/decompress-run-length-encoded-list/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }
        int[] res = new int[count];
        int idx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(res, idx, idx + nums[i], nums[i + 1]);
            idx += nums[i];
        }
        return res;
    }
}
