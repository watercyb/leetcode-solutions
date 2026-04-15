/*
 * Problem: 1253. Reconstruct a 2-Row Binary Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int count = 0;
        int total = 0;
        for (int col : colsum) {
            count += col / 2;
            total += col;
        }
        if (total != upper + lower || upper < count || lower < count)
            return new ArrayList<>();
        upper -= count;
        lower -= count;
        List<Integer> up = new ArrayList<>();
        List<Integer> lo = new ArrayList<>();
        for (int col : colsum) {
            if (col == 2) {
                up.add(1);
                lo.add(1);
            } else if (col == 0) {
                up.add(0);
                lo.add(0);
            } else if (upper > 0) {
                up.add(1);
                lo.add(0);
                upper--;
            } else {
                up.add(0);
                lo.add(1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(up);
        res.add(lo);
        return res;
    }
}
