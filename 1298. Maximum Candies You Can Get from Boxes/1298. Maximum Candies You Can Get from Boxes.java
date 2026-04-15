/*
 * Problem: 1298. Maximum Candies You Can Get from Boxes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int[] arr = new int[status.length];
        int l = 0;
        int r = 0;
        int res = 0;
        for (int idx : initialBoxes) {
            if (status[idx] == 1) {
                arr[r++] = idx;
            } else {
                status[idx] = 10;
            }
        }
        while (l < r) {
            int current = arr[l++];
            res += candies[current];
            for (int key : keys[current]) {
                if (status[key] == 10) {
                    status[key] = 1;
                    arr[r++] = key;
                } else {
                    status[key] = 1;
                }
            }
            for (int box : containedBoxes[current]) {
                if (status[box] == 1) {
                    arr[r++] = box;
                } else {
                    status[box] = 10;
                }
            }
        }
        return res;
    }
}
