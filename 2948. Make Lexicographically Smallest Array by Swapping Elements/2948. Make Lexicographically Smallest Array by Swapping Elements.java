/*
 * Problem: 2948. Make Lexicographically Smallest Array by Swapping Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        long[] arr1 = new long[nums.length];
        int prv = arr[0][0];
        long idx = 1_000_000_001;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] - limit > prv) {
                idx += 1_000_000_001;
            }
            arr1[i] = idx + arr[i][1];
            prv = arr[i][0];
        }
        Arrays.sort(arr1);
        int[] res = new int[nums.length];
        for (int i = 0; i < arr1.length; i++) {
            res[(int) (arr1[i] % 1_000_000_001)] = arr[i][0];
        }
        return res;
    }
}
