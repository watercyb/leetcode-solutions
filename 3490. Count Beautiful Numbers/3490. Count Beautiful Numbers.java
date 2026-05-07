/*
 * Problem: 3490. Count Beautiful Numbers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-beautiful-numbers/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    static HashMap<Long, Integer> HM = new HashMap<>();

    public int beautifulNumbers(int l, int r) {
        return count(r) - count(l - 1);
    }

    public int count(int num) {
        int[] arr = new int[9];
        int idx = 0;
        while (num > 0) {
            arr[idx++] = num % 10;
            num /= 10;
        }
        return dfs(arr, idx - 1, 1, 0, true, true);
    }

    public int dfs(int[] arr, int i, int pro, int sum, boolean isZero, boolean isLim) {
        if (i == -1)
            return sum != 0 && pro % sum == 0 ? 1 : 0;
        long h = ((long) pro << 15) + (sum << 5) + i;
        if (!isZero && !isLim && HM.containsKey(h))
            return HM.get(h);
        int res = 0;
        if (isLim) {
            res = dfs(arr, i - 1, pro * arr[i], sum + arr[i], false, true);
            for (int j = 0; j < arr[i]; j++) {
                if (isZero && j == 0) {
                    res += dfs(arr, i - 1, pro, sum, true, false);
                } else {
                    res += dfs(arr, i - 1, pro * j, sum + j, false, false);
                }
            }
        } else {
            for (int j = 0; j <= 9; j++) {
                if (isZero && j == 0) {
                    res += dfs(arr, i - 1, pro, sum, true, false);
                } else {
                    res += dfs(arr, i - 1, pro * j, sum + j, false, false);
                }
            }
        }
        if (!isZero && !isLim)
            HM.put(h, res);
        return res;
    }
}
