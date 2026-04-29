/*
 * Problem: 2678. Number of Senior Citizens
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-senior-citizens/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String detail : details) {
            if ((detail.charAt(11) - '0') * 10 + detail.charAt(12) - '0' > 60)
                res++;
        }
        return res;
    }
}
