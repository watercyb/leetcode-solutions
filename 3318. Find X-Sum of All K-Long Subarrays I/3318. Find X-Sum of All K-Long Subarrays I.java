/*
 * Problem: 3318. Find X-Sum of All K-Long Subarrays I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = count(nums, i, i + k - 1, x);
        }
        return res;
    }

    public int count(int[] nums, int l, int r, int x) {
        int[] counts = new int[51];
        while (l <= r) {
            counts[nums[l]]++;
            l++;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            if (counts[i] > 0)
                list.add(new int[] { counts[i], i });
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        int res = 0;
        for (int i = 0; i < Math.min(x, list.size()); i++) {
            int[] arr = list.get(i);
            res += arr[0] * arr[1];
        }
        return res;
    }
}
