/*
 * Problem: 2819. Minimum Relative Loss After Buying Chocolates
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-relative-loss-after-buying-chocolates/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long[] minimumRelativeLosses(int[] prices, int[][] queries) {
        Arrays.sort(prices);
        long[] sums = new long[prices.length + 2];
        for (int i = 0; i < prices.length; i++) {
            sums[i + 1] = sums[i] + prices[i];
        }
        sums[prices.length + 1] = sums[prices.length];
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int m = queries[i][1];
            long k2 = 2l * k;
            int idx = findLeft(prices, k, k2, m);
            res[i] = sums[idx + 1]
                    + k2 * (m - idx - 1) - sums[prices.length + 1] + sums[prices.length - m + idx + 1];
        }
        return res;
    }

    public int findLeft(int[] prices, int k, long k2, int m) {
        int l = 0;
        int r = m;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int leftIdx = mid - 1;
            int rightIdx = prices.length - m + mid;
            if ((rightIdx > 0 && leftIdx >= 0 && prices[leftIdx] > k2 - prices[rightIdx - 1])) {
                r = mid;
            } else if (leftIdx + 1 < prices.length && rightIdx < prices.length
                    && prices[leftIdx + 1] < k2 - prices[rightIdx]) {
                l = mid + 1;
            } else {
                l = r = mid;
            }
        }
        return l - 1;
    }
}
