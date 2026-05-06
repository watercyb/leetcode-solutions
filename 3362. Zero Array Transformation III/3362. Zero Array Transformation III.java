/*
 * Problem: 3362. Zero Array Transformation III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zero-array-transformation-iii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int[] arr = new int[nums.length + 1];
        List<Integer>[] lists = new ArrayList[nums.length];
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            if (lists[l] == null)
                lists[l] = new ArrayList<>();
            lists[l].add(r);
        }
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        PQ.offer(-1);
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lists[i] != null) {
                for (int r : lists[i]) {
                    PQ.offer(r);
                }
            }
            sum += arr[i];
            while (sum < nums[i]) {
                int r = PQ.poll();
                if (r < i)
                    return -1;
                sum++;
                arr[r + 1]--;
            }
        }
        return PQ.size() - 1;
    }
}
