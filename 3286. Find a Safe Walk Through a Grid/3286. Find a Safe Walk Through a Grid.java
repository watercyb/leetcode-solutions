/*
 * Problem: 3286. Find a Safe Walk Through a Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-a-safe-walk-through-a-grid/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] arr = new int[grid.size()][];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = grid.get(i);
            arr[i] = new int[list.size()];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = list.get(j);
            }
        }
        Deque<int[]> Qu = new ArrayDeque<>();
        Qu.offer(new int[] { 0, 0, arr[0][0] });
        arr[0][0] = -1;
        while (!Qu.isEmpty()) {
            int[] current = Qu.pollFirst();
            if (current[2] == health)
                return false;
            if (current[0] == arr.length - 1 && current[1] == arr[0].length - 1)
                return true;
            if (current[0] > 0 && arr[current[0] - 1][current[1]] >= 0) {
                if (arr[current[0] - 1][current[1]] == 0) {
                    Qu.offerFirst(new int[] { current[0] - 1, current[1], current[2] });
                } else {
                    Qu.offerLast(new int[] { current[0] - 1, current[1], current[2] + 1 });
                }
                arr[current[0] - 1][current[1]] = -1;
            }
            if (current[0] < arr.length - 1 && arr[current[0] + 1][current[1]] >= 0) {
                if (arr[current[0] + 1][current[1]] == 0) {
                    Qu.offerFirst(new int[] { current[0] + 1, current[1], current[2] });
                } else {
                    Qu.offerLast(new int[] { current[0] + 1, current[1], current[2] + 1 });
                }
                arr[current[0] + 1][current[1]] = -1;
            }
            if (current[1] > 0 && arr[current[0]][current[1] - 1] >= 0) {
                if (arr[current[0]][current[1] - 1] == 0) {
                    Qu.offerFirst(new int[] { current[0], current[1] - 1, current[2] });
                } else {
                    Qu.offerLast(new int[] { current[0], current[1] - 1, current[2] + 1 });
                }
                arr[current[0]][current[1] - 1] = -1;
            }
            if (current[1] < arr[0].length - 1 && arr[current[0]][current[1] + 1] >= 0) {
                if (arr[current[0]][current[1] + 1] == 0) {
                    Qu.offerFirst(new int[] { current[0], current[1] + 1, current[2] });
                } else {
                    Qu.offerLast(new int[] { current[0], current[1] + 1, current[2] + 1 });
                }
                arr[current[0]][current[1] + 1] = -1;
            }
        }
        return false;
    }
}
