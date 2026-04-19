/*
 * Problem: 1624. Largest Substring Between Two Equal Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chrs=s.toCharArray();
        int[] in=new int['z'];
        int max=-1;
        for (int i=0;i<chrs.length;i++) {
            if (in[chrs[i]-'a']==0) {
                in[chrs[i]-'a']=i+1;
            } else {
                max=Math.max(max,i-in[chrs[i]-'a']);
            }

        }
        return max;
        
    }
}
