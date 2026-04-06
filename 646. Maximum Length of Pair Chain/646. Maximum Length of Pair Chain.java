/*
 * Problem: 646. Maximum Length of Pair Chain
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-length-of-pair-chain/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int findLongestChain(int[][] pairs) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][1] > max)
                max = pairs[i][1];
            if (pairs[i][1] < min)
                min = pairs[i][1];
        }

        int[] arr = new int[max - min + 1];
        Arrays.fill(arr, -1001);
        for (int i = 0; i < pairs.length; i++) {
            int r = pairs[i][1] - min;
            if (arr[r] < pairs[i][0])
                arr[r] = pairs[i][0];
        }
        int res = 0;
        int lastPoint = -1001;
        for (int i = 0; i < max - min + 1; i++) {
            if (lastPoint < arr[i]) {
                res++;
                lastPoint = i + min;
            }
        }
        return res;

    }

}
