/*
 * Problem: 1935. Maximum Number of Words You Can Type
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-words-you-can-type/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] brokens = new boolean['z' + 1];
        for (char chr : brokenLetters.toCharArray()) {
            brokens[chr] = true;
        }
        int res = 0;
        for (String str : text.split(" ")) {
            for (char chr : str.toCharArray()) {
                if (brokens[chr]) {
                    res--;
                    break;
                }
            }
            res++;
        }
        return res;
    }
}
