/*
 * Problem: 2496. Maximum Value of a String in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int maximumValue(String[] strs) {
        int res=0;
        for (String str:strs) {
            int count=0;
            for (char chr:str.toCharArray()) {
                if (chr>='a') {
                    count=str.length();
                    break;
                } else {
                    count=count*10+(chr-'0');
                }
            }
            res=Math.max(count,res);
        }
        return res;
    }
}
