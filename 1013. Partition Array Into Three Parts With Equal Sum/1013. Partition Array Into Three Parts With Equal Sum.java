/*
 * Problem: 1013. Partition Array Into Three Parts With Equal Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sumTotal = 0;
        for (int num : arr) {
            sumTotal += num;
        }
        if (sumTotal % 3 != 0)
            return false;
        sumTotal /= 3;
        int count = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum == sumTotal) {
                count++;
                sum = 0;
            }
        }
        return count >= 3;
    }
}
