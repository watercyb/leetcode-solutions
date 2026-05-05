/*
 * Problem: 3279. Maximum Total Area Occupied by Pistons
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-total-area-occupied-by-pistons/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long maxArea(int height, int[] positions, String directions) {
        int[] arr = new int[2 * height + 1];
        int sum = 0;
        long area = 0;
        for (int i = 0; i < positions.length; i++) {
            if (directions.charAt(i) == 'U') {
                sum++;
                arr[height - positions[i]] -= 2;
                arr[2 * height - positions[i]] += 2;
            } else {
                sum--;
                arr[positions[i]] += 2;
                arr[height + positions[i]] -= 2;
            }
            area += positions[i];
        }
        long res = area;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            area += sum;
            res = Math.max(area, res);
        }
        return res;
    }
}
