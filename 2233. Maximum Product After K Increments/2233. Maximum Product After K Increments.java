/*
 * Problem: 2233. Maximum Product After K Increments
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-after-k-increments/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumProduct(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == nums.length - 1 || (sum + k) / (i + 1) < nums[i + 1]) {
                int a = (int) ((sum + k) / (i + 1));
                if (a == 0)
                    return 0;
                long res = 0;
                if (a == 1) {
                    res = pow(2, (int) (sum + k - i - 1));
                } else {
                    int len1 = (int) ((sum + k) / a);
                    int len2 = (int) ((sum + k) % a);
                    res = pow(a, len1 - len2) * pow(a + 1, len2) % mod;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    res = res * nums[j] % mod;
                }
                return (int) res;
            }
        }
        return -1;
    }

    int mod = 1_000_000_007;

    public long pow(long a, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return res;
    }
}
