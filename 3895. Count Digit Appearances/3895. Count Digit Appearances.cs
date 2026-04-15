/*
 * Problem: 3895. Count Digit Appearances
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-digit-appearances/
 * Language: csharp
 * Date: 2026-04-15
 */

public class Solution {
    public int CountDigitOccurrences(int[] nums, int digit) {
        int res=0;
        foreach (int num in nums) {
            int n=num;
            while (n>0) {
                if (n%10==digit) res++;
                n/=10;
            }
        }
        return res;
    }
}
