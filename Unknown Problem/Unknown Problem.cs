/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/digit-frequency-score/
 * Language: csharp
 * Date: 2026-06-01
 */

public class Solution {
    public int DigitFrequencyScore(int n) {
        int[] counts=new int[10];
        while (n>0) {
            counts[n%10]++;
            n/=10;
        }
        int res=0;
        for (int i=1;i<=9;i++) {
            res+=i*counts[i];
        }
        return res;
    }
}
