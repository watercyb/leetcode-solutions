/*
 * Problem: 2935. Maximum Strong Pair XOR II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-strong-pair-xor-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int res = 0;
        int mask = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] seen;
        int lim = max * 2 + 1;
        int[] arr = new int[lim];
        int maxLength = 31 - Integer.numberOfLeadingZeros(max);
        for (int i = maxLength; i >= 0; i--) {
            seen = new boolean[lim];
            int next = res + (1 << i);
            mask += (1 << i);
            for (int num : nums) {
                int numMasked = num & mask;
                int XOR = next ^ numMasked;
                if (seen[XOR] && num <= arr[XOR] * 2) {
                    res = next;
                    break;
                }
                seen[numMasked] = true;
                arr[numMasked] = num;
            }
        }
        return res;
    }
}
