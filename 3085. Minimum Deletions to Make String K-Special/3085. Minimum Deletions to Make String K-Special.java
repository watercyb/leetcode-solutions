/*
 * Problem: 3085. Minimum Deletions to Make String K-Special
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] counts = new int['z' + 1];
        for (char chr : word.toCharArray()) {
            counts[chr]++;
        }
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > 0)
                count++;
        }
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > 0)
                arr[idx++] = counts[i];
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length && sum < res; i++) {
            int max = arr[i] + k;
            int n = 0;
            for (int j = arr.length - 1; arr[j] > max; j--) {
                n += arr[j] - max;
            }
            res = Math.min(n + sum, res);
            sum += arr[i];
        }
        return res;
    }
}
