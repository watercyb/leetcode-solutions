/*
 * Problem: 1657. Determine if Two Strings Are Close
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/determine-if-two-strings-are-close/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        char[] chrs1 = word1.toCharArray();
        char[] chrs2 = word2.toCharArray();

        int[] counts1 = new int['z' + 1];
        int[] counts2 = new int['z' + 1];
        int max=0;
        for (int i = 0; i < chrs1.length; i++) {
            counts1[chrs1[i]]++;
            counts2[chrs2[i]]++;
      
        }
        int[] nums=new int[100001];
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts2[i]>0) {
                if (counts1[i]==0) return false;
                nums[counts2[i]]++;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts1[i]>0) {
                if (nums[counts1[i]]--==0) return false;
            }
        }
        return true;

    }
}
