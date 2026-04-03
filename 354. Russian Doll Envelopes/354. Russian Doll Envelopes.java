/*
 * Problem: 354. Russian Doll Envelopes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/russian-doll-envelopes/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        long[] arr =new long[envelopes.length];
        for (int i=0;i<envelopes.length;i++) {
            arr[i]= ((long)envelopes[i][0]<<32) + 0x7fffffff-envelopes[i][1];
        }
        Arrays.sort(arr);
        int[] DP = new int[envelopes.length];
        Arrays.fill(DP, Integer.MAX_VALUE);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int w=0x7fffffff-(int)arr[i];
            int l = 0;
            int r = i;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (DP[mid] >= w) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (DP[l] == Integer.MAX_VALUE)
                max = l;
            DP[l] = w;
        }
        return max + 1;
    }
}
