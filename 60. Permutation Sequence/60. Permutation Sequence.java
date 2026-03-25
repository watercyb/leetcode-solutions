/*
 * Problem: 60. Permutation Sequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/permutation-sequence/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    int[] arr = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320};

    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        int tmp = arr[n - 1];
        int a = (k + tmp - 1) / tmp;
        int b = (k - 1) % tmp + 1;
        String str = getPermutation(n - 1, b);
        StringBuilder res = new StringBuilder(String.valueOf(a));
        for (char chr : str.toCharArray()) {
            if (chr >= a + '0') {
                res.append((char) (chr + 1));
            } else {
                res.append(chr);
            }
        }
        return res.toString();
    }
}
