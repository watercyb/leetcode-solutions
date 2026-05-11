/*
 * Problem: 3823. Reverse Letters Then Special Characters in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-letters-then-special-characters-in-a-string/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public String reverseByType(String s) {
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = chrs.length - 1;
        while (true) {
            while (l < r && !Character.isLetter(chrs[l])) {
                l++;
            }
            while (r > l && !Character.isLetter(chrs[r])) {
                r--;
            }
            if (l < r) {
                swap(chrs, l, r);
            } else {
                break;
            }
            l++;
            r--;
        }
        l = 0;
        r = chrs.length - 1;
        while (true) {
            while (l < r && Character.isLetter(chrs[l])) {
                l++;
            }
            while (r > l && Character.isLetter(chrs[r])) {
                r--;
            }
            if (l < r) {
                swap(chrs, l, r);
            } else {
                break;
            }
            l++;
            r--;
        }
        return new String(chrs);
    }

    public void swap(char[] chrs, int l, int r) {
        char temp = chrs[l];
        chrs[l] = chrs[r];
        chrs[r] = temp;
    }
}
