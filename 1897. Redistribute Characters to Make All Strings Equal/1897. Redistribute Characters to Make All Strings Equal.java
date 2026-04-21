/*
 * Problem: 1897. Redistribute Characters to Make All Strings Equal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean makeEqual(String[] words) {
        int[] sum=new int[26];
        for (String str:words) {
            for (char chr:str.toCharArray()){
                sum[chr-'a']++;
            }
        }
        for (int i=0;i<26;i++) {
            if (sum[i]%words.length!=0) return false;
        }
        return true;

    }
}
