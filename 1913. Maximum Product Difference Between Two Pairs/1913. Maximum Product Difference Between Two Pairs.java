/*
 * Problem: 1913. Maximum Product Difference Between Two Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int maxProductDifference(int[] nums) {
        int[] res={0,0,10001,10001};
        for (int num:nums) {
            if (num>res[1]) {
                res[1]=num;
                if (res[1]>res[0]) {
                    int tmp=res[0];
                    res[0]=res[1];
                    res[1]=tmp;
                }
            }
            if (num<res[2]) {
                res[2]=num;
                if (res[2]<res[3]) {
                    int tmp=res[3];
                    res[3]=res[2];
                    res[2]=tmp;
                }
            }
        }
        return res[0]*res[1]-res[2]*res[3];
        
    }
}
