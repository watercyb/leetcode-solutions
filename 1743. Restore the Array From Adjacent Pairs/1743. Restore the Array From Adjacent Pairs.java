/*
 * Problem: 1743. Restore the Array From Adjacent Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] res = new int[adjacentPairs.length + 1];
        HashMap<Integer, int[]> HM = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            if (HM.containsKey(adjacentPair[0])) {
                HM.get(adjacentPair[0])[1]=adjacentPair[1];
            } else {
                HM.put(adjacentPair[0], new int[] {adjacentPair[1],Integer.MAX_VALUE});
            }
            if (HM.containsKey(adjacentPair[1])) {
                HM.get(adjacentPair[1])[1]=adjacentPair[0];
            } else {
                List<Integer> tmp = new ArrayList<>();
                HM.put(adjacentPair[1], new int[] {adjacentPair[0],Integer.MAX_VALUE});
            }
        }
        for (Map.Entry<Integer, int[]> entry : HM.entrySet()) {
            if (entry.getValue()[1] == Integer.MAX_VALUE) {
                res[0] = entry.getKey();
                res[1] = entry.getValue()[0];
                break;
            }
        }
        for (int i = 2; i <= adjacentPairs.length; i++) {
            int[] tmp = HM.get(res[i - 1]);
            if (tmp[0] != res[i - 2]) {
                res[i] = tmp[0];
            } else {
                res[i] = tmp[1];
            }
        }
        return res;
    }
}
