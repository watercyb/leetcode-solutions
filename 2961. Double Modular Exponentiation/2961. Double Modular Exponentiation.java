/*
 * Problem: 2961. Double Modular Exponentiation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/double-modular-exponentiation/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            if (chk(variables[i], target))
                res.add(i);
        }
        return res;
    }

    public boolean chk(int[] v, int t) {
        return pow(pow(v[0], v[1], 10), v[2], v[3]) == t;
    }

    public double pow(double a, int b, int mod) {
        double res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            b /= 2;
        }
        return res;
    }
}
