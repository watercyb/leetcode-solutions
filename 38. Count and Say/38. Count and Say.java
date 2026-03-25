/*
 * Problem: 38. Count and Say
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-and-say/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String countAndSay(int n) {
        StringBuilder SB = new StringBuilder();
        SB.append('1');
        for (int i = 1; i < n; i++) {
            SB = getSB(SB);
        }
        return SB.toString();
    }

    public StringBuilder getSB(StringBuilder SB) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        char prv = SB.charAt(0);
        for (int j = 1; j < SB.length(); j++) {
            char chr = SB.charAt(j);
            if (chr == prv) {
                count++;
            } else {
                res.append(count);
                res.append(prv);
                prv = chr;
                count = 1;
            }
        }
        res.append(count);
        res.append(prv);
        return res;
    }
}
