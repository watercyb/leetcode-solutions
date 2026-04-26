/*
 * Problem: 2343. Query Kth Smallest Trimmed Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/query-kth-smallest-trimmed-number/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        List<int[]>[] lists = new ArrayList[101];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int max = 0;
        for (int i = 0; i < queries.length; i++) {
            lists[queries[i][1]].add(new int[] { queries[i][0], i });
            max = Math.max(queries[i][1], max);
        }
        int len = nums[0].length();
        int[] res = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new StringBuilder(nums[i]).append(i).toString();
        }
        String[] numsNext = new String[nums.length];
        for (int i = 1; i <= max; i++) {
            int[] counts = new int[10];
            int idx = len - i;
            for (String num : nums) {
                counts[num.charAt(idx)-'0']++;
            }
            for (int j = 1; j <= 9; j++) {
                counts[j] += counts[j - 1];
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                numsNext[--counts[nums[j].charAt(idx)-'0']] = nums[j];
            }
            for (int[] arr : lists[i]) {
                res[arr[1]] = Integer.valueOf(numsNext[arr[0] - 1].substring(len));
            }
            String[] temp = nums;
            nums = numsNext;
            numsNext = temp;
        }
        return res;
    }
}
