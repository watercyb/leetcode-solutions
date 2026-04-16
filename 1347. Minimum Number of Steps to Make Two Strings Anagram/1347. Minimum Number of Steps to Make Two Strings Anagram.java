/*
 * Problem: 1347. Minimum Number of Steps to Make Two Strings Anagram
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minSteps(String s, String t) {
        int[] nums=new int['z'+1];
        char[] chrS=s.toCharArray();
        char[] chrT=t.toCharArray();
        for (int i=0;i<chrS.length;i++) {
            nums[chrS[i]]++;
            nums[chrT[i]]--;
        }

        int res=0;
        for (int num:nums) {
            if (num>0) res+=num;
        }
        return res;
        
    }
}
