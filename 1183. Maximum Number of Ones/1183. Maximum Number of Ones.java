/*
 * Problem: 1183. Maximum Number of Ones
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-ones/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[] arr = new int[sideLength * sideLength];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i % sideLength * sideLength + j % sideLength]++;
            }
        }
        countingSort(arr);
        int res = 0;
        for (int i = arr.length - 1; i >= 0 && maxOnes > 0; i--) {
            maxOnes--;
            res += arr[i];
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
