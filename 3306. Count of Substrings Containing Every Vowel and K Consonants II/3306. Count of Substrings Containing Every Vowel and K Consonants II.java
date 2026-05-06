/*
 * Problem: 3306. Count of Substrings Containing Every Vowel and K Consonants II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int countOfSubstrings(String word, int k) {
        char[] chrs = word.toCharArray();
        int[] isVowals = new int['z' + 1];
        isVowals['a'] = 1;
        isVowals['e'] = 2;
        isVowals['i'] = 3;
        isVowals['o'] = 4;
        isVowals['u'] = 5;
        int[] counts = new int[6];
        int vowals = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            counts[isVowals[chrs[i]]]++;
            if (isVowals[chrs[i]] > 0 && counts[isVowals[chrs[i]]] == 1)
                vowals++;
            while (counts[0] > k) {
                counts[isVowals[chrs[j]]]--;
                if (isVowals[chrs[j]] > 0 && counts[isVowals[chrs[j]]] == 0)
                    vowals--;
                j++;
            }
            if (vowals == 5 && counts[0] == k)
                res += getCount(chrs, isVowals, counts.clone(), j);
        }
        return res;
    }

    public int getCount(char[] chrs, int[] isVowals, int[] counts, int i) {
        int res = 1;
        while (isVowals[chrs[i]] > 0 && counts[isVowals[chrs[i]]] > 1) {
            counts[isVowals[chrs[i]]]--;
            res++;
            i++;
        }
        return res;
    }
}
