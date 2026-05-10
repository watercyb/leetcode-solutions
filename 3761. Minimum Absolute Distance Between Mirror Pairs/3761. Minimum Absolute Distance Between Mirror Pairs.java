/*
 * Problem: 3761. Minimum Absolute Distance Between Mirror Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && res > 1; i++) {
            if (HM.containsKey(nums[i]))
                res = Math.min(res, i - HM.get(nums[i]));
            HM.put(rev(nums[i]), i);
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    public int rev(int num) {
        long res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        if (res > Integer.MAX_VALUE)
            return 0;
        return (int) res;
    }
}
