/*
 * Problem: 3800. Minimum Cost to Make Two Binary Strings Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-make-two-binary-strings-equal/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        char[] chrsS = s.toCharArray();
        char[] chrsT = t.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < chrsS.length; i++) {
            if (chrsS[i] == chrsT[i])
                continue;
            if (chrsS[i] == '1') {
                a++;
            } else {
                b++;
            }
        }
        int min = Math.min(a, b);
        long res = (long) min * Math.min(2 * flipCost, swapCost);
        int rem = Math.max(a, b) - min;
        if (rem % 2 == 1)
            res += flipCost;
        res += (long) rem / 2 * Math.min(2 * flipCost, swapCost + crossCost);
        return res;
    }
}
