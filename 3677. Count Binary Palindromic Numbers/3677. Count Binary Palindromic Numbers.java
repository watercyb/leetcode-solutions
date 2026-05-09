/*
 * Problem: 3677. Count Binary Palindromic Numbers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-binary-palindromic-numbers/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int countBinaryPalindromes(long n) {
        if (n == 1)
            return 2;
        String str = Long.toBinaryString(n);
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        int res = get(arr.length);
        return res + dfs(arr, new int[arr.length], 0, arr.length - 1);
    }

    public int dfs(int[] arr, int[] arr1, int i, int j) {
        if (i > j) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] > arr1[k])
                    return 1;
                if (arr[k] < arr1[k])
                    return 0;
            }
            return 1;
        }
        int res = 0;
        if (arr[i] == 1) {
            if (i > 0)
                res = (int) Math.pow(2, (j - i) / 2);
            arr1[i] = arr1[j] = 1;
            res += dfs(arr, arr1, i + 1, j - 1);
        }
        if (arr[i] == 0) {
            arr1[i] = arr1[j] = 0;
            res += dfs(arr, arr1, i + 1, j - 1);
        }
        return res;
    }

    public int get(int len) {
        int res = 0;
        if (len > 2) {
            int n = (len - 1) / 2;
            res = (int) Math.pow(2, n) - 1;
        }
        if (len >= 2 && len <= 3) {
            res += 2;
        } else if (len > 3) {
            int n = (len - 2) / 2;
            res += (int) Math.pow(2, n + 1);
        }
        return res;
    }
}
