/*
 * Problem: 1387. Sort Integers by The Power Value
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sort-integers-by-the-power-value/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    static int[][] powers;

    public int getKth(int lo, int hi, int k) {
        if (powers == null)
            getAll();
        int idx = -1;
        while (k > 0) {
            idx++;
            while (powers[idx][1] < lo || powers[idx][1] > hi) {
                idx++;
            }
            k--;
        }
        return powers[idx][1];
    }

    public void getAll() {
        powers = new int[1001][2];
        int[] mems = new int[5001];
        for (int i = 1000; i >= 1; i--) {
            if (powers[i][1] != i) {
                powers[i][1] = i;
                powers[i][0] = dfs(mems, powers, i);
            }
        }
        Arrays.sort(powers, (a, b) -> a[0] - b[0]);
    }

    public int dfs(int[] mems, int[][] powers, int num) {
        if (num == 1)
            return 0;
        if (num < mems.length && mems[num] != 0)
            return mems[num];
        int tmp = num;
        if (tmp % 2 == 0) {
            tmp /= 2;
        } else {
            tmp = 3 * tmp + 1;
        }
        int res = dfs(mems, powers,  tmp);
        if (tmp <= 1000 && powers[tmp][1] != tmp) {
            powers[tmp][1] = tmp;
            powers[tmp][0] = res;
        }
        if (num < mems.length)
            mems[num] = res + 1;
        return res + 1;
    }
}
