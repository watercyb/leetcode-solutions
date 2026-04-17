/*
 * Problem: 1424. Diagonal Traverse II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/diagonal-traverse-ii/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> Li = new ArrayList<>();
        int count = 0;
        int idx = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> tmp = nums.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                idx = j + i;
                if (idx == Li.size())
                    Li.add(new ArrayList<>());
                Li.get(idx).add(tmp.get(j));
                count++;
            }
        }
        int[] res = new int[count];
        idx = 0;
        for (List<Integer> tmp : Li) {
            for (int i = tmp.size() - 1; i >= 0; i--) {
                res[idx++] = tmp.get(i);
            }
        }
        return res;
    }
}
