/*
 * Problem: 1086. High Five
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/high-five/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, int[]> HM = new HashMap<>();
        for (int[] item : items) {
            if (!HM.containsKey(item[0])) {
                int[] tmp = new int[5];
                tmp[0] = item[1];
                HM.put(item[0], tmp);
            } else {
                int[] tmp = HM.get(item[0]);
                if (item[1] > tmp[4]) {
                    int i = 4;
                    while (i > 0 && tmp[i - 1] < item[1]) {
                        tmp[i] = tmp[i - 1];
                        i--;
                    }
                    tmp[i] = item[1];
                }
            }
        }
        int[][] res = new int[HM.size()][2];
        int i = 0;
        for (Map.Entry<Integer, int[]> entry : HM.entrySet()) {
            int[] v = entry.getValue();
            res[i++] = new int[] { entry.getKey(), (v[0] + v[1] + v[2] + v[3] + v[4]) / 5 };
        }
        return res;
    }
}
