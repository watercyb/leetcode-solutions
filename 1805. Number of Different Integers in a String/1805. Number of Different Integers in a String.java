/*
 * Problem: 1805. Number of Different Integers in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-different-integers-in-a-string/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> HS = new HashSet<>();
        StringBuilder SB = new StringBuilder();
        boolean hasDigit = false;
        boolean leadingZero = true;
        int res = 0;
        for (char chr : word.toCharArray()) {
            if (Character.isDigit(chr)) {
                hasDigit = true;
                if (!leadingZero || chr != '0') {
                    SB.append(chr);
                    leadingZero = false;
                }
            } else {
                if (hasDigit) {
                    if (SB.isEmpty()) {
                        if (HS.add("0"))
                            res++;
                    } else if (HS.add(SB.toString())) {
                        res++;
                    }
                }
                SB.setLength(0);
                hasDigit = false;
                leadingZero = true;
            }
        }
        if (hasDigit) {
            if (SB.isEmpty()) {
                if (HS.add("0"))
                    res++;
            } else if (HS.add(SB.toString())) {
                res++;
            }
        }
        return res;
    }
}
