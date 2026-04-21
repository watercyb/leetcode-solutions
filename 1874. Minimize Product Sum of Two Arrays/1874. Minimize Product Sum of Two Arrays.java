/*
 * Problem: 1874. Minimize Product Sum of Two Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-product-sum-of-two-arrays/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] counts1 = sort(nums1);
        int[] counts2 = sort(nums2);
        int res = 0;
        int i = 0;
        int j = counts2.length - 1;
        while (i < counts1.length) {
            if (counts1[i] == 0) {
                i++;
            } else if (counts2[j] == 0) {
                j--;
            } else {
                res += i * j;
                counts1[i]--;
                counts2[j]--;
            }
        }
        return res;
    }

    public int[] sort(int[] nums) {
        int[] counts = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        return counts;
    }
}
