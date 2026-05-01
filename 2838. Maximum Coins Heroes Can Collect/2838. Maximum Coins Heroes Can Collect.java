/*
 * Problem: 2838. Maximum Coins Heroes Can Collect
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-coins-heroes-can-collect/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        long[][] pairs = new long[monsters.length + 1][2];
        for (int i = 0; i < monsters.length; i++) {
            pairs[i + 1] = new long[] { monsters[i], coins[i] };
        }
        Arrays.sort(pairs, (a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < monsters.length; i++) {
            pairs[i + 1][1] += pairs[i][1];
        }
        long[] res = new long[heroes.length];
        for (int i = 0; i < heroes.length; i++) {
            res[i] = binarySearch(pairs, heroes[i]);
        }
        return res;
    }

    public long binarySearch(long[][] pairs, int target) {
        int l = 0;
        int r = pairs.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (pairs[mid][0] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return pairs[l - 1][1];
    }
}
