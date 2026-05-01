/*
 * Problem: 2824. Count Pairs Whose Sum is Less than Target
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        for (int num : nums) {
            res += get(target - num);
            insert(num);
        }
        return res;
    }

    int[] BIT = new int[102];
    int count = 0;

    public int get(int i) {
        i += 50;
        if (i <= 0)
            return 0;
        if (i >= BIT.length)
            return count;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }

    public void insert(int i) {
        count++;
        i += 51;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }
}
