/*
 * Problem: 290. Word Pattern
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/word-pattern/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] list = new String['z' + 1];
        HashSet<String> HS = new HashSet<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length)
            return false;
        for (int i = 0; i < strs.length; i++) {
            char chr = pattern.charAt(i);
            if (list[chr] == null) {
                if (!HS.add(strs[i]))
                    return false;
                list[chr] = strs[i];
            } else {
                if (!strs[i].equals(list[chr]))
                    return false;
            }
        }
        return true;
    }
}
