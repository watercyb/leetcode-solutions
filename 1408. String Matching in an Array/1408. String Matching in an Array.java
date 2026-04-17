/*
 * Problem: 1408. String Matching in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/string-matching-in-an-array/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
