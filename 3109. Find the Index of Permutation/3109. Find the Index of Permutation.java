/*
 * Problem: 3109. Find the Index of Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-index-of-permutation/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {

    int mod = 1_000_000_007;

    public int getPermutationIndex(int[] perm) {
        long res = 0;
        BIT = new int[perm.length + 2];
        long[] arr = new long[perm.length];
        for (int i = 0; i < perm.length; i++) {
            insert(perm[i]);
            arr[i] = perm[i] - get(perm[i]);
        }
        long p = 1;
        for (int i = perm.length - 1; i >= 0; i--) {
            res += arr[i] * p;
            p = p * (perm.length - i) % mod;
        }
        return (int) (res % mod);
    }

    int[] BIT;

    public void insert(int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
