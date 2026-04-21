/*
 * Problem: 1815. Maximum Number of Groups Getting Fresh Donuts
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        if (batchSize == 1)
            return groups.length;
        int[] counts = new int[batchSize];
        for (int group : groups) {
            counts[group % batchSize]++;
        }
        int res = counts[0];
        int l = 1;
        int r = batchSize - 1;
        int n = groups.length - counts[0];
        while (l < r) {
            int count = Math.min(counts[l], counts[r]);
            res += count;
            counts[l++] -= count;
            counts[r--] -= count;
            n -= count * 2;
        }
        if (l == r) {
            int count = counts[l] / 2;
            res += count;
            counts[l] %= 2;
            n -= count * 2;
        }
        if (n <= 1)
            return res + n;
        int count = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0)
                count++;
        }
        int[] nums = new int[count];
        int[] freqs = new int[count];
        int idx = 0;
        int sum = 0;
        long h = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0)
                continue;
            nums[idx] = i;
            freqs[idx] = counts[i];
            h += (long) counts[i] << (5 * idx++);
            sum += i * counts[i];
        }
        if (sum <= batchSize)
            return res + 1;
        return res + dfs(nums, freqs, h, 0, batchSize);
    }

    HashMap<Long, Integer> HM = new HashMap<>();

    public int dfs(int[] nums, int[] freqs, long h, int m, int batchSize) {
        if (h == 0)
            return m > 0 ? 1 : 0;
        long k = (h << 4) + m;
        if (HM.containsKey(k))
            return HM.get(k);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freqs[i] > 0) {
                freqs[i]--;
                if (m + nums[i] == batchSize) {
                    res = Math.max(res, dfs(nums, freqs, h - (1l << (5 * i)), 0, batchSize) + 1);
                } else {
                    res = Math.max(res, dfs(nums, freqs, h - (1l << (5 * i)), (m + nums[i]) % batchSize, batchSize));
                }
                freqs[i]++;
            }
        }
        HM.put(k, res);
        return res;
    }
}
