/*
 * Problem: 13. Roman to Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/roman-to-integer/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int romanToInt(String s) {
        int[] nums=new int['Y'];
        nums['I']=1;
        nums['V']=5;
        nums['X']=10;
        nums['L']=50;
        nums['C']=100;
        nums['D']=500;
        nums['M']=1000;
        int prv=1000;
        int res=0;
        for (char chr:s.toCharArray()) {
            if (nums[chr]>prv) {
                res-=2*prv;
            }
            res+=nums[chr];
            prv=nums[chr];
        }
        return res;
    }
}
