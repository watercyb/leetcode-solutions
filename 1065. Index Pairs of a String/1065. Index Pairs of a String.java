/*
 * Problem: 1065. Index Pairs of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/index-pairs-of-a-string/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String str : words) {
            int l = str.length() - 1;
            int idx = text.indexOf(str);
            while (idx >= 0) {
                list.add(new int[] { idx, idx + l });
                idx = text.indexOf(str, idx + 1);
            }
        }
        int[][] res = new int[list.size()][2];
        list.toArray(res);
        Arrays.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return res;
    }
}
