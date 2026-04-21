/*
 * Problem: 1868. Product of Two Run-Length Encoded Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int count1 = encoded1[0][1];
        int j = 0;
        int count2 = encoded2[0][1];
        int prv = encoded1[0][0] * encoded2[0][0];
        int count = 0;
        while (i < encoded1.length) {
            int current = encoded1[i][0] * encoded2[j][0];
            if (current != prv) {
                res.add(List.of(prv, count));
                count = 0;
                prv = current;
            }
            int min = Math.min(encoded1[i][1], encoded2[j][1]);
            count += min;
            encoded1[i][1] -= min;
            encoded2[j][1] -= min;
            if (encoded1[i][1] == 0)
                i++;
            if (encoded2[j][1] == 0)
                j++;
        }
        res.add(List.of(prv, count));
        return res;
    }
}
