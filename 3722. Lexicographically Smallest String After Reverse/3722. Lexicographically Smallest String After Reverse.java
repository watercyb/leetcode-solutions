/*
 * Problem: 3722. Lexicographically Smallest String After Reverse
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-reverse/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String lexSmallest(String s) {
        String res = s;
        for (int i = 0; i < s.length() - 1; i++) {
            if (chkLeft(res, s, i))
                res = new StringBuilder(s.substring(0, i + 1)).reverse().append(s.substring(i + 1)).toString();
            if (chkRight(res, s, i))
                res = new StringBuilder(s.substring(0, i))
                        .append(new StringBuilder(s.substring(i)).reverse().toString()).toString();
        }
        return res;
    }

    public boolean chkLeft(String a, String s, int i) {
        for (int j = 0; j <= i; j++) {
            if (a.charAt(j) > s.charAt(i - j)) {
                return true;
            } else if (a.charAt(j) < s.charAt(i - j)) {
                return false;
            }
        }
        for (int j = i + 1; j < a.length(); j++) {
            if (a.charAt(j) > s.charAt(j)) {
                return true;
            } else if (a.charAt(j) < s.charAt(j)) {
                return false;
            }
        }
        return false;
    }

    public boolean chkRight(String a, String s, int i) {
        for (int j = 0; j < i; j++) {
            if (a.charAt(j) > s.charAt(j)) {
                return true;
            } else if (a.charAt(j) < s.charAt(j)) {
                return false;
            }
        }
        for (int j = i; j < a.length(); j++) {
            if (a.charAt(j) > s.charAt(s.length() - 1 - j + i)) {
                return true;
            } else if (a.charAt(j) < s.charAt(s.length() - 1 - j + i)) {
                return false;
            }
        }
        return false;
    }
}
