/*
 * Problem: 975. Odd Even Jump
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/odd-even-jump/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int oddEvenJumps(int[] arr) {
        int res = 1;
        boolean[][] DP = new boolean[arr.length][2];
        DP[arr.length - 1] = new boolean[] { true, true };
        int[] idx = new int[100001];
        Arrays.fill(idx, -1);
        idx[arr[arr.length - 1]] = arr.length - 1;
        int max = arr[arr.length - 1];
        int min = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
            int j = arr[i];
            while (j >= min && idx[j] == -1) {
                j--;
            }
            if (j >= min) {
                DP[i][1] = DP[idx[j]][0];
            }
            j = arr[i];
            while (j <= max && idx[j] == -1) {
                j++;
            }
            if (j <= max) {
                DP[i][0] = DP[idx[j]][1];
                if (DP[i][0])
                    res++;
            }
            idx[arr[i]] = i;
        }
        return res;
    }
}
