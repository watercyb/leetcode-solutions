/*
 * Problem: 1064. Fixed Point
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fixed-point/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int fixedPoint(int[] arr) {
        int l=0;
        int r=arr.length;
        int res=-1;
        while (l<r) {
            int mid=(l+r)>>>1;
            if (arr[mid]>mid) {
                r=mid;
            } else if (arr[mid]<mid) {
                l=mid+1;
            } else {
                r=mid;
                res=mid;
            }
        }
        return res;
    }
}
