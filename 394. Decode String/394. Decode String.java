/*
 * Problem: 394. Decode String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decode-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
   public int n;
    public String decodeString(String s) {
        n=0;
        return findBracket(s.toCharArray()).toString();
    }

    public StringBuilder findBracket(char[] chrs) {
        StringBuilder str = new StringBuilder();
        int in = 0;
        while (n<chrs.length){
            if (chrs[n] == '[') {
                n++;
                StringBuilder strN = findBracket(chrs);
                for (int j = 0; j < in; j++) {
                    str.append(strN);
                }
                in=0;
                continue;
            }
            if (chrs[n] == ']') {
                n++;
                return str;
            }
            if (chrs[n] >= 'a') {
                str.append(chrs[n]);
                n++;
                continue;
            }
            if (chrs[n] <= '9') {
                in = in*10 + Integer.valueOf(chrs[n])-48;
                n++;
                continue;
            }
        }
      
        return str;

    }
}
