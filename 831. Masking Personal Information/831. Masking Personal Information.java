/*
 * Problem: 831. Masking Personal Information
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/masking-personal-information/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            StringBuilder SB = new StringBuilder();
            String[] strs = s.split("@");
            SB.append(Character.toLowerCase(strs[0].charAt(0)));
            for (int i = 0; i < 5; i++) {
                SB.append('*');
            }
            SB.append(Character.toLowerCase(strs[0].charAt(strs[0].length() - 1)));
            SB.append('@');
            for (char chr : strs[1].toCharArray()) {
                if (chr != '.') {
                    SB.append(Character.toLowerCase(chr));
                } else {
                    SB.append(chr);
                }
            }
            return SB.toString();
        } else {
            List<Integer> list = new ArrayList<>();
            for (char chr : s.toCharArray()) {
                if (Character.isDigit(chr))
                    list.add(chr - '0');
            }
            StringBuilder SB = new StringBuilder();
            if (list.size() == 10) {
                SB.append("***-***-");
            } else if (list.size() == 11) {
                SB.append("+*-***-***-");
            } else if (list.size() == 12) {
                SB.append("+**-***-***-");
            } else {
                SB.append("+***-***-***-");
            }
            for (int i = list.size() - 4; i < list.size(); i++) {
                SB.append(list.get(i));
            }
            return SB.toString();
        }
    }
}
