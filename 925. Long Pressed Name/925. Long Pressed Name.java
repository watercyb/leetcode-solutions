/*
 * Problem: 925. Long Pressed Name
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/long-pressed-name/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] chrsN = name.toCharArray();
        char[] chrsT = typed.toCharArray();
        if (chrsN[0] != chrsT[0] || chrsN.length > chrsT.length)
            return false;
        int j = 1;
        for (int i = 1; i < chrsN.length; i++) {
            if (j == chrsT.length)
                return false;
            if (chrsN[i] == chrsT[j]) {
                j++;
            } else {
                while (j < chrsT.length && chrsT[j] == chrsT[j - 1]) {
                    j++;
                }
                if (j == chrsT.length || chrsN[i] != chrsT[j])
                    return false;
                j++;
            }
        }
        while (j < chrsT.length && chrsT[j] == chrsT[j - 1]) {
            j++;
        }
        return j == chrsT.length;
    }
}
