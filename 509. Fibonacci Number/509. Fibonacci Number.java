/*
 * Problem: 509. Fibonacci Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fibonacci-number/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int fib(int n) {
        int[] re=new int[n+2];
        re[0]=0;
        re[1]=1;
        for (int i=2;i<=n;i++) {
            re[i]=re[i-1]+re[i-2];
        }
        return re[n];
        
    }
    
    
}
