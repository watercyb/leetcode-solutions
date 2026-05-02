/*
 * Problem: 2942. Find Words Containing Character
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-words-containing-character/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0)
                res.add(i);
        }
        return res;
    }
}
