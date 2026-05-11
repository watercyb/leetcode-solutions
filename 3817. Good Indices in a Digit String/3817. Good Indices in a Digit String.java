/*
 * Problem: 3817. Good Indices in a Digit String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/good-indices-in-a-digit-string/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public List<Integer> goodIndices(String s) {
        char[] chrs = s.toCharArray();
        int num = 0;
        List<Integer> res = new ArrayList<>();
        int base = 10;
        for (int i = 0; i < chrs.length; i++) {
            if (base == i)
                base *= 10;
            num = (num * 10 + chrs[i] - '0') % 100000;
            if (num % base == i)
                res.add(i);
        }
        return res;
    }
}
