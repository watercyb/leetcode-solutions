/*
 * Problem: 2011. Final Value of Variable After Performing Operations
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '-') {
                res--;
            } else {
                res++;
            }
        }
        return res;
    }
}
