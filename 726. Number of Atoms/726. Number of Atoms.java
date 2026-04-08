/*
 * Problem: 726. Number of Atoms
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-atoms/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String countOfAtoms(String formula) {
        int[] counts = dfs(formula.toCharArray());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                res.append((char) (i / 27 + 'A' - 1));
                if (i % 27 > 0)
                    res.append((char) (i % 27 + 'a' - 1));
                if (counts[i] > 1)
                    res.append(counts[i]);
            }
        }
        return res.toString();
    }

    int idx = 0;

    public int[] dfs(char[] chrs) {
        int[] res = new int[27 * 27];
        int h = -1;
        while (idx < chrs.length) {
            if (chrs[idx] == '(') {
                idx++;
                int[] counts = dfs(chrs);
                int num = 0;
                while (idx < chrs.length && Character.isDigit(chrs[idx])) {
                    num = num * 10 + chrs[idx] - '0';
                    idx++;
                }
                if (num == 0)
                    num = 1;
                for (int i = 0; i < res.length; i++) {
                    res[i] += num * counts[i];
                }
            } else if (chrs[idx] == ')') {
                if (h != -1)
                    res[h]++;
                idx++;
                return res;
            } else if (Character.isUpperCase(chrs[idx])) {
                if (h != -1) {
                    res[h]++;
                }
                h = (chrs[idx] - 'A' + 1) * 27;
                idx++;
            } else if (Character.isLowerCase(chrs[idx])) {
                h += chrs[idx] - 'a' + 1;
                idx++;
            } else if (Character.isDigit(chrs[idx])) {
                int num = 0;
                while (idx < chrs.length && Character.isDigit(chrs[idx])) {
                    num = num * 10 + chrs[idx] - '0';
                    idx++;
                }
                res[h] += num;
                h = -1;
            }
        }
        if (h != -1)
            res[h]++;
        return res;
    }
}
