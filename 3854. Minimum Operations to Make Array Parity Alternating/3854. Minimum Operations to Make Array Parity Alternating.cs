/*
 * Problem: 3854. Minimum Operations to Make Array Parity Alternating
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-parity-alternating/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public int[] MakeParityAlternating(int[] nums) {
        if (nums.Length==1) return new int[] {0,0};
        int dpEven=0;
        int dpOdd=0;
        int max=int.MinValue;
        int min=int.MaxValue;
        foreach (int num in nums) {
            if ((num&1)==1) {
                int dpOddNext=dpEven;
                int dpEvenNext=dpOdd+1;
                dpEven=dpEvenNext;
                dpOdd=dpOddNext;
            } else {
                int dpOddNext=dpEven+1;
                int dpEvenNext=dpOdd;
                dpEven=dpEvenNext;
                dpOdd=dpOddNext;
            }
            max=Math.Max(max,num);
            min=Math.Min(min,num);
        }
        if (Math.Abs(max-min)<=1) return new int[] {Math.Min(dpEven, dpOdd), 1};
        int change=0;
        if (dpEven<=dpOdd) {
            int idx=(nums.Length&1)^1;
            int maxChange=1;
            int minChange=1;
            foreach (int num in nums) {
                if ((num&1)==idx) {
                    if (num==max) {
                        maxChange=0;
                    } else if (num==min) {
                        minChange=0;
                    }
                }
                idx=1-idx;
            }
            change=maxChange+minChange;
        }
        if (dpEven>=dpOdd) {
            int idx=(nums.Length&1)^0;
            int maxChange=1;
            int minChange=1;
            foreach (int num in nums) {
                if ((num&1)==idx) {
                    if (num==max) {
                        maxChange=0;
                    } else if (num==min) {
                        minChange=0;
                    }
                }
                idx=1-idx;
            }
            change=Math.Max(change,maxChange+minChange);
        }
        return new int[] {Math.Min(dpEven, dpOdd), max-min-change};
    }
}
