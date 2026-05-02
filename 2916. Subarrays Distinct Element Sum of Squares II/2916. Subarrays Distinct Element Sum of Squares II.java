/*
 * Problem: 2916. Subarrays Distinct Element Sum of Squares II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    long[] SGT;
    long[] cache;

    public int sumCounts(int[] nums) {
        int mod = 1_000_000_007;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int l = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
        int size = (int) Math.pow(2, l) - 1;
        SGT = new long[2 * size + 1];
        cache = new long[2 * size + 1];
        int[] counts = new int[nums.length];
        int[] lastPos = new int[max + 1];
        long res = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            long tmp = getAndAdd(lastPos[nums[i]], i, 0, size, 0);
            //System.out.println(Arrays.toString(SGT));
            sum += 2 * tmp + i - lastPos[nums[i]] + 1;
            lastPos[nums[i]] = i + 1;
            res = (res + sum) % mod;
        }
        return (int) res;
    }

    public void add(int n, long val, int i) {
        SGT[i] += n * val;
        cache[i] += val;
    }

    public long getAndAdd(int l, int r, int left, int right, int i) {
        if (right < l || left > r)
            return 0;
        if (left >= l && right <= r) {
            long res = SGT[i];
            add(right - left + 1, 1, i);
            return res;
        }
        SGT[i] += Math.min(r, right) - Math.max(l, left) + 1;
        int mid = (left + right) >>> 1;
        if (cache[i] > 0) {
            add(mid - left + 1, cache[i], 2 * i + 1);
            add(right - mid, cache[i], 2 * i + 2);
            cache[i] = 0;
        }
        return getAndAdd(l, r, left, mid, 2 * i + 1) + getAndAdd(l, r, mid + 1, right, 2 * i + 2);
    }
}
