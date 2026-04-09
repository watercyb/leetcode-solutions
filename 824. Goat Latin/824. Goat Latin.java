/*
 * Problem: 824. Goat Latin
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/goat-latin/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String toGoatLatin(String sentence) {
        boolean[] vowels = new boolean['z' + 1];
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['O'] = true;
        vowels['U'] = true;
        StringBuilder suffix = new StringBuilder("maa");
        StringBuilder res = new StringBuilder();
        char first = ' ';
        for (char chr : sentence.toCharArray()) {
            if (chr == ' ') {
                if (!vowels[first])
                    res.append(first);
                res.append(suffix);
                res.append(' ');
                suffix.append('a');
                first = ' ';
            } else {
                if (first == ' ') {
                    first = chr;
                    if (vowels[chr])
                        res.append(chr);
                } else {
                    res.append(chr);
                }
            }
        }
        if (!vowels[first])
            res.append(first);
        res.append(suffix);
        return res.toString();
    }
}
