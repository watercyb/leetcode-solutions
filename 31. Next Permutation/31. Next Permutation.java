/*
 * Problem: 31. Next Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/next-permutation/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int[] counts = new int[101];
        int max = nums[nums.length - 1];
        counts[max]++;
        for (int i = nums.length - 2; i >= 0; i--) {
            counts[nums[i]]++;
            if (nums[i] < max) {
                int j = nums[i] + 1;
                while (counts[j] == 0) {
                    j++;
                }
                nums[i] = j;
                counts[j]--;
                i++;
                for (int k = 0; k <= max; k++) {
                    for (int l = 0; l < counts[k]; l++) {
                        nums[i++] = k;
                    }
                }
                return;
            }
            max = nums[i];
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
