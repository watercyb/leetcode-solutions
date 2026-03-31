/*
 * Problem: 288. Unique Word Abbreviation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-word-abbreviation/
 * Language: java
 * Date: 2026-03-31
 */

class ValidWordAbbr {
    int[] seens = new int[26 * 20 * 26];
    HashSet<String> HS = new HashSet<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String str : dictionary) {
            if (HS.add(str))
                seens[getH(str)]++;
        }
    }

    public boolean isUnique(String word) {
        return seens[getH(word)] == 0 || (seens[getH(word)] == 1 && HS.contains(word));
    }

    public int getH(String str) {
        return ((str.charAt(0) - 'a') * 520 + (str.length() - 1) * 26 + (str.charAt(str.length() - 1) - 'a'));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
