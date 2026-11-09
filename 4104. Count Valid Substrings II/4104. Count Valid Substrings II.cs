/*
 * Problem: 4104. Count Valid Substrings II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-valid-substrings-ii/
 * Language: csharp
 * Date: 2026-11-09
 */

public class Solution {
    public long CountValidSubstrings(string s) {
        int lastA=-1;
        int lastB=-1;
        int lastAB=-1;
        long res=0;
        int j=0;
        for (int i=0;i<s.Length;i++) {
            char chr=s[i];
            if (chr=='a') {
                lastA=i;
            } else if (chr=='b') {
                lastAB=lastA;
            } else {
                j=Math.Max(j, lastAB+1);
            }
            res+=i-j+1;
        }
        return res;
    }
}
