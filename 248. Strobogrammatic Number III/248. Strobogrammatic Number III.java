/*
 * Problem: 248. Strobogrammatic Number III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/strobogrammatic-number-iii/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public int strobogrammaticInRange(String low, String high) {
        char[] chrsL = low.toCharArray();
        if (low.equals(high))
            return chk(chrsL);
        char[] chrsH = high.toCharArray();
        int res = dfs(chrsH, new char[chrsH.length], 0, chrsH.length - 1)
                - dfs(chrsL, new char[chrsL.length], 0, chrsL.length - 1) + chk(chrsL);
        for (int i = chrsL.length; i < chrsH.length; i++) {
            res += getCountByLength(i);
        }
        return res;
    }

    public int getCountByLength(int i) {
        if (i == 1) {
            return 3;
        } else if (i == 2) {
            return 4;
        } else {
            int res = 4;
            for (int j = 1; j < (i - 1) / 2; j++) {
                res *= 5;
            }
            if (i % 2 == 1) {
                res *= 3;
            } else {
                res *= 5;
            }
            return res;
        }
    }

    public int chk(char[] chrs) {
        int l = 0;
        int r = chrs.length - 1;
        while (l <= r) {
            if (!((chrs[l] == '0' && chrs[r] == '0') || (chrs[l] == '1' && chrs[r] == '1')
                    || (chrs[l] == '8' && chrs[r] == '8') || (chrs[l] == '6' && chrs[r] == '9')
                    || (chrs[l] == '9' && chrs[r] == '6')))
                return 0;
            l++;
            r--;
        }
        return 1;
    }

    public int dfs(char[] chrs, char[] arr, int l, int r) {
        if (l > r)
            return chk(chrs, arr);
        int res = 0;
        if (l != 0 || l == r) {
            arr[l] = '0';
            arr[r] = '0';
            res = dfs(chrs, arr, l + 1, r - 1);
        }
        arr[l] = '1';
        arr[r] = '1';
        res += dfs(chrs, arr, l + 1, r - 1);
        arr[l] = '8';
        arr[r] = '8';
        res += dfs(chrs, arr, l + 1, r - 1);
        if (l != r) {
            arr[l] = '6';
            arr[r] = '9';
            res += dfs(chrs, arr, l + 1, r - 1);
            arr[l] = '9';
            arr[r] = '6';
            res += dfs(chrs, arr, l + 1, r - 1);
        }
        return res;
    }

    public int chk(char[] chrs, char[] arr) {
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] > arr[i]) {
                return 1;
            } else if (chrs[i] < arr[i]) {
                return 0;
            }
        }
        return 1;
    }
}
