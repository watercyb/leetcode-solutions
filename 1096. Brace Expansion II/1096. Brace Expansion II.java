/*
 * Problem: 1096. Brace Expansion II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/brace-expansion-ii/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public List<String> braceExpansionII(String expression) {
        chrs = new StringBuilder("{").append(expression).append("}").toString().toCharArray();
        List<String> res = dfs();
        Collections.sort(res);
        return res;
    }

    char[] chrs;
    int idx = 1;

    public List<String> dfs() {
        List<String> res = new ArrayList<>();
        List<String> prv = null;
        while (chrs[idx] != '}') {
            if (chrs[idx] == ',') {
                merge(res, prv);
                prv = null;
                idx++;
            } else if (chrs[idx] == '{') {
                idx++;
                List<String> next = dfs();
                if (prv == null) {
                    prv = next;
                } else {
                    prv = product(prv, next);
                }
            } else {
                StringBuilder SB = new StringBuilder();
                while (Character.isLetter(chrs[idx])) {
                    SB.append(chrs[idx]);
                    idx++;
                }
                if (prv == null) {
                    prv = new ArrayList<>();
                    prv.add(SB.toString());
                } else {
                    prv = product(prv, SB.toString());
                }
            }
        }
        if (prv != null)
            merge(res, prv);
        idx++;
        return res;
    }

    public void merge(List<String> a, List<String> b) {
        HashSet<String> HS = new HashSet<>();
        HS.addAll(a);
        for (String str : b) {
            if (HS.add(str))
                a.add(str);
        }
    }

    public List<String> product(List<String> a, List<String> b) {
        HashSet<String> HS = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String str1 : a) {
            for (String str2 : b) {
                String str = new StringBuilder(str1).append(str2).toString();
                if (HS.add(str))
                    res.add(str);
            }
        }
        return res;
    }

    public List<String> product(List<String> a, String b) {
        List<String> res = new ArrayList<>();
        for (String str : a) {
            res.add(new StringBuilder(str).append(b).toString());
        }
        return res;
    }
}
