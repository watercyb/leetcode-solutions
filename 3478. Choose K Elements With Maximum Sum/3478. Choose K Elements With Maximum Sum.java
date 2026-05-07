/*
 * Problem: 3478. Choose K Elements With Maximum Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/choose-k-elements-with-maximum-sum/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int[][] arr = new int[nums1.length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[] { nums1[i], nums2[i], i };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        PQ.offer(arr[0][1]);
        long sum = arr[0][1];
        long[] res = new long[nums1.length];
        res[arr[0][2]] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] == arr[i - 1][0]) {
                res[arr[i][2]] = res[arr[i - 1][2]];
            } else {
                res[arr[i][2]] = sum;
            }
            if (PQ.size() < k || arr[i][1] > PQ.peek()) {
                PQ.offer(arr[i][1]);
                sum += arr[i][1];
                if (PQ.size() > k)
                    sum -= PQ.poll();
            }
        }
        return res;
    }
}
