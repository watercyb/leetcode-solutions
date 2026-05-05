/*
 * Problem: 3276. Select Cells in Grid With Maximum Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/select-cells-in-grid-with-maximum-score/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int[][] arr = new int[grid.size()][];
        for (int i = 0; i < arr.length; i++) {
            int[] counts = new int[101];
            int count = 0;
            for (int num : grid.get(i)) {
                if (counts[num]++ == 0)
                    count++;
            }
            arr[i] = new int[count];
            int idx = 0;
            for (int j = counts.length - 1; j >= 0; j--) {
                if (counts[j] > 0)
                    arr[i][idx++] = j;
            }
        }
        int[] DP = new int[1 << arr.length];
        int[] mins = new int[DP.length];
        mins[0] = Integer.MAX_VALUE;
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int mask = 1 << j;
                if ((i & mask) != 0) {
                    int idx = i - mask;
                    int min = mins[idx];
                    int num = 0;
                    for (int k = 0; k < arr[j].length; k++) {
                        if (arr[j][k] < min) {
                            num = arr[j][k];
                            break;
                        }
                    }
                    if (DP[idx] + num > DP[i]) {
                        DP[i] = DP[idx] + num;
                        mins[i] = num;
                    }
                }
            }
        }
        return DP[DP.length - 1];
    }
}
