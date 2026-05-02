/*
 * Problem: 2902. Count of Sub-Multisets With Bounded Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int mod = 1_000_000_007;
        int[] counts = new int[20001];
        for (int num : nums) {
            counts[num]++;
        }
        long[] DP = new long[r + 1];
        DP[0] = 1;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                long[] DPNext = new long[r + 1];
                for (int j = 0; j < i; j++) {
                    int left = j;
                    int right = j;
                    long sum = 0;
                    int count = 0;
                    while (right <= r) {
                        sum += DP[right];
                        if (count > counts[i]) {
                            sum -= DP[left];
                            left += i;
                        }
                        DPNext[right] = sum % mod;
                        count++;
                        right += i;
                    }
                }
                DP = DPNext;
            }
        }
        long res = 0;
        for (int i = l; i <= r; i++) {
            res += DP[i];
        }
        res = res % mod * (counts[0] + 1) % mod;
        return (int) res;
    }
}
