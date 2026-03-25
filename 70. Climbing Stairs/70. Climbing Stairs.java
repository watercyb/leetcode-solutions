/*
 * Problem: 70. Climbing Stairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/climbing-stairs/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int climbStairs(int n) {
        int a=1;
        int b=0;
        
        for (int i=2;i<=n;i++) {
            a=a+b;
            b=a-b;
        }
        
        return a+b;
        
    }
    
}
