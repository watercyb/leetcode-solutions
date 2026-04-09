/*
 * Problem: 873. Length of Longest Fibonacci Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> HS = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            HS.add(arr[i]);
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.pow(1.62, res - 1) * arr[i] > arr[arr.length - 1])
                break;
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.pow(1.62, res - 2) * arr[j] > arr[arr.length - 1])
                    break;
                int a = arr[i];
                int b = arr[j];
                int stp = 2;
                while (HS.contains(a + b)) {
                    int temp = b;
                    b = a + b;
                    a = temp;
                    stp++;
                }
                res = Math.max(stp, res);
            }
        }
        if (res == 2)
            return 0;
        return res;
    }
}
