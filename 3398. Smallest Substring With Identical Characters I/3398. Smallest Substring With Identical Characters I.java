/*
 * Problem: 3398. Smallest Substring With Identical Characters I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-substring-with-identical-characters-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minLength(String s, int numOps) {
        char[] chrs = s.toCharArray();
        int[] arr = new int[chrs.length];
        int idx = 0;
        int len = 0;
        char prv = '#';
        for (char chr : chrs) {
            if (chr == prv) {
                len++;
            } else {
                if (len > 1)
                    arr[idx++] = len;
                len = 1;
                prv = chr;
            }
        }
        if (len > 1)
            arr[idx++] = len;
        int l = 1;
        int r = s.length() + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(chrs, arr, idx, numOps, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(char[] chrs, int[] arr, int idx, int n, int mid) {
        if (mid == 1) {
            int digit = 1;
            int a = 0;
            int b = 0;
            for (char chr : chrs) {
                chr -= '0';
                if (chr == digit) {
                    a++;
                } else {
                    b++;
                }
                digit = 1 - digit;
            }
            return Math.min(a, b) <= n;
        } else {
            mid++;
            for (int i = 0; i < idx && n >= 0; i++) {
                n -= arr[i] / mid;
            }
            return n >= 0;
        }
    }
}
