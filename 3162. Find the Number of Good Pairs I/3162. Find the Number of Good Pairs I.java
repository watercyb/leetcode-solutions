/*
 * Problem: 3162. Find the Number of Good Pairs I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-number-of-good-pairs-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res=0;
        for (int num1:nums1) {
            if (num1%k!=0) continue;
            num1/=k;
            for (int num2:nums2) {
                if (num1%num2==0) res++;
            }
        }
        return res;
    }
}
