/*
 * Problem: 2953. Count Complete Substrings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-complete-substrings/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int countCompleteSubstrings(String word, int k) {
        char[] chrs = word.toCharArray();
        int prv = 0;
        int res = 0;
        for (int i = 1; i < chrs.length; i++) {
            if (chrs[i] - chrs[i - 1] > 2 || chrs[i] - chrs[i - 1] < -2) {
                res += getSum(chrs, prv, i - 1, k);
                prv = i;
            }
        }
        res += getSum(chrs, prv, chrs.length - 1, k);
        return res;
    }

    public int getSum(char[] chrs, int l, int r, int k) {
        int res = 0;
        for (int i = 1; i <= 26 && i * k <= r - l + 1; i++) {
            res += getCount(chrs, l, r, i, k);
        }
        return res;
    }

    public int getCount(char[] chrs, int l, int r, int n, int k) {
        int len = n * k;
        int count = 0;
        int[] counts = new int[26];
        int res = 0;
        for (int i = l; i < len + l; i++) {
            int idx = chrs[i] - 'a';
            counts[idx]++;
            if (counts[idx] == k) {
                count++;
            } else if (counts[idx] == k + 1) {
                count--;
            }
        }
        if (count == n)
            res++;
        for (int i = len + l; i <= r; i++) {
            int idx = chrs[i] - 'a';
            counts[idx]++;
            if (counts[idx] == k) {
                count++;
            } else if (counts[idx] == k + 1) {
                count--;
            }
            idx = chrs[i - len] - 'a';
            counts[idx]--;
            if (counts[idx] == k) {
                count++;
            } else if (counts[idx] == k - 1) {
                count--;
            }
            if (count == n)
                res++;
        }
        return res;
    }
}
