/*
 * Problem: 118. Pascal's Triangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/pascals-triangle/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> Li = new ArrayList<>();
            Li.add(1);
            int tmp = 1;
            for (int j = 1; j < i; j++) {
                tmp *= (i - j);
                tmp /= j;
                Li.add(tmp);
            }
            res.add(Li);
        }
        return res;
    }
}
