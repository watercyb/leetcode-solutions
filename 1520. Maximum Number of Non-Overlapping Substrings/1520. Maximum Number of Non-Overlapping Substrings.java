/*
 * Problem: 1520. Maximum Number of Non-Overlapping Substrings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        char[] chrs = s.toCharArray();
        int[][] ranges = new int['z' + 1][2];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i][0] = -1;
        }
        for (int i = 0; i < chrs.length; i++) {
            if (ranges[chrs[i]][0] == -1)
                ranges[chrs[i]][0] = i;
            ranges[chrs[i]][1] = i;
        }
        List<String> res = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (ranges[chrs[i]][1] == i) {
                int l = ranges[chrs[i]][0];
                int r = i;
                int j = r - 1;
                while (j > l && ranges[chrs[j]][1] <= r && l >= last) {
                    l = Math.min(ranges[chrs[j]][0], l);
                    j--;
                }
                if (j <= l) {
                    res.add(new String(chrs, l, r - l + 1));
                    last = r;
                }
            }
        }
        // System.out.println(Arrays.toString(counts));
        return res;
    }
}
