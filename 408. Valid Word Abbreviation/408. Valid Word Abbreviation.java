/*
 * Problem: 408. Valid Word Abbreviation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-word-abbreviation/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] chrW=word.toCharArray();
        char[] chrA=abbr.toCharArray();
        int i = 0;
        int j = 0;
        while (j < chrA.length) {
            int num = 0;
            if (chrA[j]< 'a') {
                if (chrA[j] == '0')
                    return false;
                while (chrA[j] < 'a') {
                    num *= 10;
                    num += chrA[j] - '0';
                    j++;
                    if (j == chrA.length)
                        return i + num == chrW.length;
                }
            }
            i += num;
            if (i >= chrW.length || chrW[i]!= chrA[j])
                return false;
            i++;
            j++;
        }
        return (i == chrW.length && j == chrA.length);
    }
}
