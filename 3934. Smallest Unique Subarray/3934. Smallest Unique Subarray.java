/*
 * Problem: 3934. Smallest Unique Subarray
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-unique-subarray/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int l = 1;
        int r = nums.length;
        HM = new HashMap<>(nums.length, 0.99f);
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    HashMap<Integer, Integer> HM;

    public boolean chk(int[] nums, int mid) {
        HM.clear();
        int mod = 1_000_000_007;
        int n = 100_003;
        long h = 0;
        long base = 1;
        for (int i = 0; i < mid - 1; i++) {
            h = (h * n + nums[i]) % mod;
            base = base * n % mod;
        }
        h = (h * n + nums[mid - 1]) % mod;
        HM.put((int) h, 1);
        int count = 1;
        for (int i = mid; i < nums.length; i++) {
            h = (((h - base * nums[i - mid]) % mod + mod) * n + nums[i]) % mod;
            int c = HM.getOrDefault((int) h, 0);
            HM.put((int) h, c + 1);
            if (c == 0) {
                count++;
            } else if (c == 1) {
                count--;
            }
        }
        return count >= 1;
    }
}
