/*
 * Problem: 699. Falling Squares
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/falling-squares/
 * Language: java
 * Date: 2026-04-06
 */


class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        HashSet<Integer> HS = new HashSet<>();
        for (int[] position : positions) {
            HS.add(position[0]);
            HS.add(position[0] + position[1]);
        }
        int[] arr = new int[HS.size()];
        int idx = 0;
        for (int pos : HS) {
            arr[idx++] = pos;
        }
        Arrays.sort(arr);
        int[] heights = new int[arr.length];
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int[] position : positions) {
            int l = Arrays.binarySearch(arr, position[0]);
            int lim = position[0] + position[1] - 1;
            int h = 0;
            int r = l;
            while (arr[r] <= lim) {
                h = Math.max(heights[r], h);
                r++;
            }
            h += position[1];
            for (int i = l; i < r; i++) {
                heights[i] = h;
            }
            max = Math.max(h, max);
            res.add(max);
        }
        return res;
    }
}
