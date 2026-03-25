/*
 * Problem: 69. Sqrt(x)
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sqrtx/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int mySqrt(int x) {
        int left=2;
        int right=x/2;
        
        if (left*left>x) return Math.min(1, x);
        int mid=1;
        
        while(left<right) {
            
            mid=(left+right)/2+(left+right)%2;
            if (mid==x/mid) return mid;
            if (mid>x/mid) right=mid-1;
            if (mid<x/mid) left=mid;
        }
        
        return right;
        
    }
}
