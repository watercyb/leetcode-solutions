/*
 * Problem: 3799. Word Squares II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/word-squares-ii/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Arrays.sort(words);
        List<List<String>> res = new ArrayList<>();
        for (int t = 0; t < words.length; t++) {
            for (int l = 0; l < words.length; l++) {
                if (l == t || words[l].charAt(0) != words[t].charAt(0))
                    continue;
                for (int r = 0; r < words.length; r++) {
                    if (r == t || r == l || words[r].charAt(0) != words[t].charAt(3))
                        continue;
                    for (int b = 0; b < words.length; b++) {
                        if (b == t || b == l || b == r
                                || words[r].charAt(3) != words[b].charAt(3) || words[l].charAt(3) != words[b].charAt(0))
                            continue;
                        res.add(new ArrayList<>(Arrays.asList(words[t], words[l], words[r], words[b])));
                    }
                }
            }
        }
        return res;
    }
}
