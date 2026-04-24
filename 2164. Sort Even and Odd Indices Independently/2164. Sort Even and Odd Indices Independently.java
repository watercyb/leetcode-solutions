/*
 * Problem: 2164. Sort Even and Odd Indices Independently
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-even-and-odd-indices-independently/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] countOdd = new int[101];
        int[] countEven = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                countEven[nums[i]]++;
            } else {
                countOdd[nums[i]]++;
            }
        }
        int idxOdd = countOdd.length - 1;
        int idxEven = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                while (countEven[idxEven] == 0) {
                    idxEven++;
                }
                nums[i] = idxEven;
                countEven[idxEven]--;
            } else {
                while (countOdd[idxOdd] == 0) {
                    idxOdd--;
                }
                nums[i] = idxOdd;
                countOdd[idxOdd]--;
            }
        }
        return nums;
    }
}
