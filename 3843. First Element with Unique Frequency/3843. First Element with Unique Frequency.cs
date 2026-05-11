/*
 * Problem: 3843. First Element with Unique Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/first-element-with-unique-frequency/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public int FirstUniqueFreq(int[] nums) {
        int max=0;
        foreach (int num in nums) {
            max=Math.Max(max,num);
        }
        int[] counts=new int[max+1];
        max=0;
        foreach (int num in nums) {
            counts[num]++;
            max=Math.Max(max,counts[num]);
        }
        int[] freqs=new int[max+1];
        foreach (int count in counts) {
           freqs[count]++;
        }
        foreach (int num in nums) {
            if (freqs[counts[num]]==1) return num;
        }
        return -1;
    }
}
