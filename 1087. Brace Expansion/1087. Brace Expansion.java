/*
 * Problem: 1087. Brace Expansion
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/brace-expansion/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public String[] expand(String s) {
        List<List<Character>> list = new ArrayList<>();
        int idx = 0;
        int n = 1;
        while (idx < s.length()) {
            if (s.charAt(idx) != '{') {
                List<Character> listTmp = new ArrayList<>();
                listTmp.add(s.charAt(idx));
                list.add(listTmp);
            } else {
                int count = 0;
                List<Character> listTmp = new ArrayList<>();
                while (s.charAt(idx) != '}') {
                    idx++;
                    listTmp.add(s.charAt(idx));
                    idx++;
                    count++;
                }
                Collections.sort(listTmp);
                list.add(listTmp);
                n *= count;
            }
            idx++;
        }
        res = new String[n];
        dfs(list, 0, new StringBuilder());
        return res;
    }

    String[] res;
    int index = 0;

    public void dfs(List<List<Character>> list, int i, StringBuilder SB) {
        if (i == list.size()) {
            res[index++] = SB.toString();
            return;
        }
        for (char chr : list.get(i)) {
            SB.append(chr);
            dfs(list, i + 1, SB);
            SB.setLength(SB.length() - 1);
        }
    }
}
