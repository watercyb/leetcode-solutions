/*
 * Problem: 3224. Minimum Array Changes to Make Differences Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-array-changes-to-make-differences-equal/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minChanges(int[] nums, int k) {
        int[] line = new int[k + 2];
        int res = Integer.MAX_VALUE;
        int sum = nums.length / 2;
        for (int i = 0; i < nums.length / 2; i++) {
            int a = nums[i];
            int b = nums[nums.length - 1 - i];
            if (a > b) {
                int numTemp = a;
                a = b;
                b = numTemp;
            }
            line[b - a]--;
            line[b - a + 1]++;
            int r = Math.max(k - a, b);
            line[r + 1]++;
        }
        for (int i = 0; i <= k; i++) {
            sum += line[i];
            res = Math.min(sum, res);
        }
        return res;
    }
}
