/*
 * Problem: 2273. Find Resultant Array After Removing Anagrams
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public List<String> removeAnagrams(String[] words) {
        int l = 1;
        for (int r = 1; r < words.length; r++) {
            if (!chk(words[l - 1], words[r]))
                words[l++] = words[r];
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            res.add(words[i]);
        }
        return res;
    }

    public boolean chk(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] counts = new int[26];
        for (char chr : a.toCharArray()) {
            counts[chr - 'a']++;
        }
        for (char chr : b.toCharArray()) {
            if (counts[chr - 'a']-- == 0)
                return false;
        }
        return true;
    }
}
