/*
 * Problem: 2047. Number of Valid Words in a Sentence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int countValidWords(String sentence) {
        int res = 0;
        for (String str : sentence.split(" ")) {
            if (str.isEmpty())
                continue;
            if (chk(str))
                res++;
        }
        return res;
    }

    public boolean chk(String str) {
        int h = 0;
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (Character.isLetter(chr))
                continue;
            if (chr == '-') {
                if (h++ == 1 || i == 0 || i == str.length() - 1 || !Character.isLetter(str.charAt(i - 1))
                        || !Character.isLetter(str.charAt(i + 1)))
                    return false;
            } else if (chr == '!' || chr == '.' || chr == ',') {
                if (i != str.length() - 1)
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
