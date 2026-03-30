/*
 * Problem: 2834. Find the Minimum Possible Sum of a Beautiful Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/?envType=problem-list-v2&envId=math
 * Language: java
 * Date: 2026-03-30
 */

class Solution {
    public int minimumPossibleSum(int n, int target) {
        int l = target / 2 + 1;
        if (l > n)
            return (int) ((long) (n + 1) * n / 2 % 1_000_000_007);
        n += target - l;
        return (int) (((long) (n + 1) * n / 2 - (long) (target + target / 2) * (target - target / 2 - 1) / 2)
                % 1_000_000_007);
    }
}
