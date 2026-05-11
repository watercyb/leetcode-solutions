/*
 * Problem: 3851. Maximum Requests Without Violating the Limit
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-requests-without-violating-the-limit/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int maxRequests(int[][] requests, int k, int window) {
        requests = countingSort(requests);
        int[] arr = new int[requests.length];
        int l = 0;
        int r = 0;
        int max = 0;
        for (int[] request : requests) {
            max = Math.max(max, request[0]);
        }
        int[] counts = new int[max + 1];
        int res = requests.length;
        for (int i = 0; i < requests.length; i++) {
            int idx = requests[i][0];
            int time = requests[i][1];
            while (l < r && requests[arr[l]][1] < time - window) {
                counts[requests[arr[l++]][0]]--;
            }
            if (counts[idx] < k) {
                counts[idx]++;
                arr[r++] = i;
            } else {
                res--;
            }
        }
        return res;
    }

    public int[][] countingSort(int[][] requests) {
        int max = 0;
        for (int[] request : requests) {
            max = Math.max(max, request[1]);
        }
        int[] counts = new int[max + 1];
        for (int[] request : requests) {
            counts[request[1]]++;
        }
        for (int i = 1; i <= max; i++) {
            counts[i] += counts[i - 1];
        }
        int[][] res = new int[requests.length][];
        for (int[] request : requests) {
            res[--counts[request[1]]] = request;
        }
        return res;
    }
}
