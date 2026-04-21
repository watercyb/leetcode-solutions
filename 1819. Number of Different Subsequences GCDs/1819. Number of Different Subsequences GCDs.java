/*
 * Problem: 1819. Number of Different Subsequences GCDs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-different-subsequences-gcds/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        boolean[] seens = new boolean[max + 1];
        for (int num : nums) {
            seens[num] = true;
        }
        int res = 0;
        for (int i = 1; i <= max; i++) {
            int gcd = 0;
            for (int j = i; j <= max; j += i) {
                if (seens[j]) {
                    gcd = GCD(gcd, j);
                    if (gcd == i) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
