/*
 * Problem: 2813. Maximum Elegance of a K-Length Subsequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-elegance-of-a-k-length-subsequence/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        boolean[] seens = new boolean[items.length + 1];
        long types = 0;
        long sum = 0;
        int[] arr = new int[k];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (!seens[items[i][1]]) {
                seens[items[i][1]] = true;
                types++;
            } else {
                arr[idx++] = items[i][0];
            }
            sum += items[i][0];
        }
        long res = sum + types * types;
        int idxItems = k;
        idx--;
        while (idx >= 0 && idxItems < items.length) {
            if (!seens[items[idxItems][1]]) {
                seens[items[idxItems][1]] = true;
                sum += items[idxItems][0] - arr[idx--];
                types++;
                res = Math.max(sum + types * types, res);
            }
            idxItems++;
        }
        return res;
    }
}
