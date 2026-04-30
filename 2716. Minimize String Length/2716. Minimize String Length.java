/*
 * Problem: 2716. Minimize String Length
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimize-string-length/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int minimizedStringLength(String s) {
        boolean[] seens=new boolean[26];
        int res=0;
        for (char chr:s.toCharArray()) {
            if (!seens[chr-'a']) {
                seens[chr-'a']=true;
                res++;
            }
        }
        return res;
    }
}
