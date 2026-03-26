/*
 * Problem: 140. Word Break II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/word-break-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> HS = new HashSet<>();
        List<String> Li = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordDict.size(); i++) {
            HS.add(wordDict.get(i));
        }
        DFS(Li, HS, res, s, 0);
        return res;
    }

    public void DFS(List<String> Li, HashSet<String> HS, List<String> res, String s, int i) {
        if (i == s.length()) {
            StringBuilder SB = new StringBuilder();
            for (int j=0;j<Li.size();j++) {
                if (j>0) SB.append(" ");
                SB.append(Li.get(j));
            }
            res.add(SB.toString());
        } else {
            for (int j = i; j <= s.length(); j++) {
                String str=s.substring(i, j);
                if (HS.contains(str)) {
                    Li.add(str);
                    DFS(Li, HS, res, s, j);
                    Li.remove(Li.size()-1);
                }
            }
        }
    }
}
