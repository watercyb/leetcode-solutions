/*
 * Problem: 4. Median of Two Sorted Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0&&nums2.length==0) return 0;
        
        int n=nums1.length+nums2.length-1;
        int m=n%2;
        n=n/2;
        int re=0;
        
        int i=0;
        int j=0;
        while (i<nums1.length&&j<nums2.length) {
            if (nums1[i]<=nums2[j]) {
                if (n==0) re=nums1[i];
                if (n+m==0) return (double)(re+nums1[i])/2;
                i++;
                n--;
                continue;
            }
             if (nums1[i]>nums2[j]) {
                if (n==0) re=nums2[j];
                if (n+m==0) return (double)(re+nums2[j])/2;
                j++;
                n--;
            }
        }

        
        while(j>=nums2.length) {
                if (n==0) re=nums1[i];
                if (n+m==0) return (double)(re+nums1[i])/2;
                i++;
                n--;
                
        }

        while(i>=nums1.length) {
                if (n==0) re=nums2[j];
                if (n+m==0) return (double)(re+nums2[j])/2;
                j++;
                n--;
                
        }
        
        return -1;
        
        
    }
}
