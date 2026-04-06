/*
 * Problem: 632. Smallest Range Covering Elements from K Lists
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int l = 0;
        for (int i = 0; i < nums.size(); i++) {
            l += nums.get(i).size();
        }
        int[][] arr = new int[l][2];
        int idx = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                arr[idx++] = new int[] { num, i };
            }
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] counts = new int[nums.size()];
        int needs = nums.size();
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && needs > 0) {
                if (counts[arr[j][1]]++ == 0)
                    needs--;
                j++;
            }
            if (needs > 0)
                break;
            int length = arr[j - 1][0] - arr[i][0];
            if (length < min) {
                min = length;
                res = new int[] { arr[i][0], arr[j - 1][0] };
            }
            if (counts[arr[i][1]]-- == 1)
                needs++;
        }
        return res;
    }
}
