/*
 * Problem: 2963. Count the Number of Good Partitions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-good-partitions/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int mod = 1_000_000_007;
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!HM.containsKey(nums[i]))
                HM.put(nums[i], i);
        }
        int l = 0;
        int r = 0;
        int count = 0;
        while (l < nums.length) {
            int lim = l;
            while (r <= lim) {
                lim = Math.max(lim, HM.get(nums[r]));
                r++;
            }
            count++;
            l = r;
        }
        long res = 1;
        long base = 2;
        count--;
        while (count > 0) {
            if (count % 2 == 1)
                res = res * base % mod;
            base = base * base % mod;
            count /= 2;
        }
        return (int) res;
    }
}
