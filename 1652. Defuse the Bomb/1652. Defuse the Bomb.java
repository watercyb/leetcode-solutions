/*
 * Problem: 1652. Defuse the Bomb
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/defuse-the-bomb/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        } else if (k > 0) {
            int[] res = new int[code.length];
            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i];
            }
            k = (k + 1) % code.length;
            res[0] = sum;
            for (int i = 1; i < code.length; i++) {
                sum += code[k];
                sum -= code[i];
                res[i] = sum;
                k = (k + 1) % code.length;
            }
            return res;
        } else if (k < 0) {
            int[] res = new int[code.length];
            int sum = 0;
            k = code.length - 1 + k;
            for (int i = code.length - 2; i >= k; i--) {
                sum += code[i];
            }
            k = (k - 1 + code.length) % code.length;
            res[code.length - 1] = sum;
            for (int i = code.length - 2; i >= 0; i--) {
                if (k >= 0)
                    sum += code[k];
                sum -= code[i];
                res[i] = sum;
                k = (k - 1 + code.length) % code.length;
            }
            return res;
        }
        return code;
    }
}
