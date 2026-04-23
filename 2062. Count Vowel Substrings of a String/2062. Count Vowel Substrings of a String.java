/*
 * Problem: 2062. Count Vowel Substrings of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-vowel-substrings-of-a-string/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int countVowelSubstrings(String word) {
        char[] chrs = word.toCharArray();
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        int prv = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (!vowels[chrs[i]]) {
                res += count(chrs, prv, i - 1);
                prv = i + 1;
            }
        }
        res += count(chrs, prv, chrs.length - 1);
        return res;
    }

    boolean[] vowels = new boolean['z' + 1];

    public int count(char[] chrs, int i, int j) {
        int l = i - 1;
        int[] counts = new int['z' + 1];
        int count = 0;
        int res = 0;
        while (i <= j - 4) {
            while (l < j && count < 5) {
                l++;
                if (counts[chrs[l]]++ == 0)
                    count++;
            }
            if (count < 5)
                break;
            res += j - l + 1;
            if (counts[chrs[i]]-- == 1)
                count--;
            i++;
        }
        return res;
    }
}
