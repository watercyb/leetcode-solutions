/*
 * Problem: 2748. Number of Beautiful Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-beautiful-pairs/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int countBeautifulPairs(int[] nums) {
        int[] counts = new int[10];
        int res = 0;
        for (int num : nums) {
            int last = num % 10;
            for (int i = 1; i <= 9; i++) {
                if (GCD(i, last) == 1)
                    res += counts[i];
            }
            while (num >= 10) {
                num /= 10;
            }
            counts[num]++;
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
