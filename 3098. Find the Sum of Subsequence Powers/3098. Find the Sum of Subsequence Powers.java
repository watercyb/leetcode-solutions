/*
 * Problem: 3098. Find the Sum of Subsequence Powers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-sum-of-subsequence-powers/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            res = (res + dfs(nums, i, nums[nums.length - 1] - nums[i], k - 1)) % mod;
        }
        return (int) res;
    }

    HashMap<Long, Long> HM = new HashMap<>();
    int mod = 1_000_000_007;

    public long dfs(int[] nums, int i, int min, int k) {
        if (k == 0)
            return min;
        long h = getH(i, min, k);
        if (HM.containsKey(h))
            return HM.get(h);
        long res = 0;
        for (int j = i + 1; j <= nums.length - k; j++) {
            res = (res + dfs(nums, j, Math.min(min, nums[j] - nums[i]), k - 1)) % mod;
        }
        HM.put(h, res);
        return res;
    }

    public long getH(int i, long min, long k) {
        return (min << 12) + (i << 6) + k;
    }
}
