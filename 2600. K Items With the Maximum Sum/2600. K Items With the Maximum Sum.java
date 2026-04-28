/*
 * Problem: 2600. K Items With the Maximum Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/k-items-with-the-maximum-sum/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes)
            return k;
        if (k <= numOnes + numZeros)
            return numOnes;
        return 2 * numOnes - k + numZeros;
    }
}
