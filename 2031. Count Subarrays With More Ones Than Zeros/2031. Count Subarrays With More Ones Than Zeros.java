/*
 * Problem: 2031. Count Subarrays With More Ones Than Zeros
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-subarrays-with-more-ones-than-zeros/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int subarraysWithMoreOnesThanZeroes(int[] nums) {
        int max = 0;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += 2 * nums[i] - 1;
            max = Math.max(sum, max);
            min = Math.min(sum, min);
        }
        BIT = new int[max - min + 2];
        offset = -min + 1;
        insert(0);
        sum = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += 2 * nums[i] - 1;
            res += get(sum - 1);
            insert(sum);
        }
        return (int) (res % 1_000_000_007);
    }

    int[] BIT;
    int offset = 0;

    public void insert(int i) {
        i += offset;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i += offset;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
