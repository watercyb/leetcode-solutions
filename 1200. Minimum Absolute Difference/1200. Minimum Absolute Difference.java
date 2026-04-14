/*
 * Problem: 1200. Minimum Absolute Difference
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-absolute-difference/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        countingSort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i] - arr[i - 1], min);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }

    public void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i + min;
            }
        }
    }
}
