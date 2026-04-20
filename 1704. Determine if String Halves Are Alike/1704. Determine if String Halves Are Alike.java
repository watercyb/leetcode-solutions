/*
 * Problem: 1704. Determine if String Halves Are Alike
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> HS=new HashSet<>();
        char[] chrs={'a','e','i','o','u','A','E','I','O','U'};
        for (char chr:chrs) {
            HS.add(chr);
        }
        chrs=s.toCharArray();
        int count=0;
        for (int i=0;i<chrs.length/2;i++) {
           if (HS.contains(chrs[i])) count++;
        }
        for (int i=chrs.length/2;i<chrs.length;i++) {
           if (HS.contains(chrs[i])) count--;
        }
        return count==0;
        
    }
}
