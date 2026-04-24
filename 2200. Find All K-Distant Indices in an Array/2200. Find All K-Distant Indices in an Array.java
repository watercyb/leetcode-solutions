/*
 * Problem: 2200. Find All K-Distant Indices in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int[] arr = new int[nums.length + 2 * k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                arr[i]++;
                arr[i + 2 * k + 1]--;
            }
        }
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < nums.length + k; i++) {
            sum += arr[i];
            if (sum > 0)
                res.add(i - k);
        }
        return res;
    }
}
