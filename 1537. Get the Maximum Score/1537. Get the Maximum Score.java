/*
 * Problem: 1537. Get the Maximum Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/get-the-maximum-score/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long res = 0;
        int i = 0;
        long sum1 = 0;
        int j = 0;
        long sum2 = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j];
                j++;
            } else {
                res += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }
        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }
        return (int) ((res + Math.max(sum1, sum2)) % 1_000_000_007);
    }
}
