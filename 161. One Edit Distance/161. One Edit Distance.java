/*
 * Problem: 161. One Edit Distance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/one-edit-distance/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t))
            return false;
        char[] chrsS = s.toCharArray();
        char[] chrsT = t.toCharArray();
        if (chrsS.length == chrsT.length - 1) {
            int i = 0;
            int j = 0;
            while (i < chrsS.length && j < chrsT.length) {
                if (chrsS[i] != chrsT[j]) {
                    if (i < j)
                        return false;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        } else if (chrsS.length == chrsT.length + 1) {
            int i = 0;
            int j = 0;
            while (i < chrsS.length && j < chrsT.length) {
                if (chrsS[i] != chrsT[j]) {
                    if (i > j)
                        return false;
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        } else if (chrsS.length == chrsT.length) {
            int i = 0;
            int j = 0;
            boolean skipped = false;
            while (i < chrsS.length && j < chrsT.length) {
                if (chrsS[i] != chrsT[j]) {
                    if (skipped)
                        return false;
                    skipped = true;
                }
                i++;
                j++;
            }
            return true;
        }
        return false;
    }
}
