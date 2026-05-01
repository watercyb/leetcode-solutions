/*
 * Problem: 2843.   Count Symmetric Integers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-symmetric-integers/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        for (int i = 1; i < 100; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            dfs(i, sum, i < 10 ? 1 : 2, low, high);
        }
        return res;
    }

    int res = 0;

    public void dfs(int num, int sum, int n, int low, int high) {
        if (num > high)
            return;
        if (n == 0) {
            if (sum == 0 && num >= low) {
                res++;
            }
        } else {
            for (int i = 0; i <= Math.min(sum, 9); i++) {
                dfs(num * 10 + i, sum - i, n - 1, low, high);
            }
        }
    }
}
