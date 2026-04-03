/*
 * Problem: 367. Valid Perfect Square
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-perfect-square/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean isPerfectSquare(int num) {
       int left=1;
        int right=num;
        if (left==right) return true;

        while(left<right-1) {
            int mid=(right-left)/2+left;
            if (mid>num/mid) right=mid;
            if (mid<=num/mid) left=mid;

        }
        if (left*left==num) return true;
        return false; 
    }
}
