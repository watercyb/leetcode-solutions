/*
 * Problem: 1088. Confusing Number II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/confusing-number-ii/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int confusingNumberII(int n) {
        if (n == 1000000000)
            return confusingNumberII(999999999) + 1;
        int[] lim = new int[String.valueOf(n).length()];
        int num = n;
        for (int i = lim.length - 1; i >= 0; i--) {
            lim[i] = num % 10;
            num /= 10;
        }
        dfs(new int[lim.length], lim, 0, true);
        return res;
    }

    int res = 0;
    int[] nums = { 0, 1, 6, 8, 9 };
    int[] rev = { 0, 1, 2, 3, 4, 5, 9, 7, 8, 6 };

    public void chk(int[] arr, int[] n) {
        int l = 0;
        while (l < arr.length && arr[l] == 0) {
            l++;
        }
        int r = arr.length - 1;
        while (l < arr.length) {
            if (arr[l] != rev[arr[r]]) {
                res++;
                return;
            }
            l++;
            r--;
        }
    }

    public void dfs(int[] arr, int[] n, int i, boolean isSame) {
        if (i == arr.length) {
            chk(arr, n);
        } else if (isSame) {
            for (int j = 0; j < nums.length && nums[j] <= n[i]; j++) {
                arr[i] = nums[j];
                dfs(arr, n, i + 1, nums[j] == n[i]);
            }
        } else {
            for (int j = 0; j < nums.length; j++) {
                arr[i] = nums[j];
                dfs(arr, n, i + 1, isSame);
            }
        }
    }
}
