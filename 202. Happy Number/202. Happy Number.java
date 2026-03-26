/*
 * Problem: 202. Happy Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/happy-number/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> HS= new HashSet<Integer>();
        int nR=cal(n);
        while (nR!=1) {
            if (!HS.add(nR)) {return false;}
            nR=cal(nR);
        }
        return true;
        
    }
    
    public int cal(int n) {
        int nR=0;
        while (n>0) {
            int R=(n%10);
            nR+=R*R;
            n=n/10;
        }
        return nR;
    }
}
