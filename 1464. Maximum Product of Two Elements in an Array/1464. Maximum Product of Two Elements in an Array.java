/*
 * Problem: 1464. Maximum Product of Two Elements in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/?envType=daily-question&envId=2026-07-27
 * Language: java
 * Date: 2026-07-27
 */

class Solution {
    public int maxProduct(int[] nums) {
        int a=0;
        int b=0;
        for (int num:nums) {
            if(num>b) {
                b=num;
                if (b>a) {
                    int tmp=a;
                    a=b;
                    b=tmp;
                }
            }
        }
        return (a-1)*(b-1);
    }
}
