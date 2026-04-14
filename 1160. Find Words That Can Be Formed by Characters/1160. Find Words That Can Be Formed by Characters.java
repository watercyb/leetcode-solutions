/*
 * Problem: 1160. Find Words That Can Be Formed by Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int['z' + 1];
        int l = chars.length();
        for (char chr : chars.toCharArray()) {
            count[chr]++;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            int thisL = words[i].length();
            if (thisL > l)
                continue;
            int[] tmp = new int[26];
            for (char chr : words[i].toCharArray()) {
                int idx = chr - 'a';
                tmp[idx]++;
                if (tmp[idx] > count[chr]) {
                    res -= thisL;
                    break;
                }
            }
            res += thisL;
        }
        return res;
    }
}
