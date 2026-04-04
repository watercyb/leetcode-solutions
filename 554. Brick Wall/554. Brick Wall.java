/*
 * Problem: 554. Brick Wall
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/brick-wall/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    HashMap<Integer, Integer> HM = new HashMap<>();
    int max = 0;

    public int leastBricks(List<List<Integer>> wall) {
        for (List<Integer> row : wall) {
            insert(row);
        }
        return wall.size() - max;
    }

    public void insert(List<Integer> row) {
        int sum = 0;
        for (int i = 0; i < row.size() - 1; i++) {
            sum += row.get(i);
            int count = HM.getOrDefault(sum, 0) + 1;
            max = Math.max(count, max);
            HM.put(sum, count);
        }
    }
}
