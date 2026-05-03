/*
 * Problem: 3080. Mark Elements on Array by Performing Queries
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/mark-elements-on-array-by-performing-queries/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long sum = 0;
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = 100001l * nums[i] + i;
        }
        Arrays.sort(arr);
        long[] res = new long[queries.length];
        int idx = 0;
        for (int i = 0; i < queries.length; i++) {
            sum -= nums[queries[i][0]];
            nums[queries[i][0]] = 0;
            int j = queries[i][1];
            while (j > 0 && idx < arr.length) {
                int num = (int) (arr[idx] / 100001);
                int idxArr = (int) (arr[idx++] % 100001);
                if (nums[idxArr] == 0)
                    continue;
                sum -= num;
                nums[idxArr] = 0;
                j--;
            }
            res[i] = sum;
        }
        return res;
    }
}
