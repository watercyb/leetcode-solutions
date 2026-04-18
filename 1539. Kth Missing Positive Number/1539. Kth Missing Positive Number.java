/*
 * Problem: 1539. Kth Missing Positive Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/kth-missing-positive-number/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0;
        int r=arr.length;
        while (l<r) {
            int mid=(l+r)>>>1;
            if (arr[mid]-mid>k) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        if (l==0) return k;
        return k+l;
    }
}
