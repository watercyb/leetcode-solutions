/*
 * Problem: 1237. Find Positive Integer Solution for a Given Equation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 * Language: java
 * Date: 2026-04-15
 */

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int j = 1000;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int r = customfunction.f(i, j);
            while (j > 1 && r > z) {
                j--;
                r = customfunction.f(i, j);
            }
            if (r > z)
                break;
            if (r == z)
                res.add(Arrays.asList(i, j));
        }
        return res;
    }
}
