/*
 * Problem: 3866. First Unique Even Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/first-unique-even-element/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public int FirstUniqueEven(int[] nums) {
        int[] counts=new int[101];
        foreach (int num in nums) {
            counts[num]++;
        }
        foreach (int num in nums) {
            if (num%2==0&&counts[num]==1) return num;
        }
        return -1;
    }
}
