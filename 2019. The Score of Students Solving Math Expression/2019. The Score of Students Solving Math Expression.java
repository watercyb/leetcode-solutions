/*
 * Problem: 2019. The Score of Students Solving Math Expression
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-score-of-students-solving-math-expression/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        char[] chrs = s.toCharArray();
        int ans = getResult(chrs);
        HashSet<Integer>[][] HS = new HashSet[chrs.length][chrs.length];
        HashSet<Integer> two = dfs(chrs, HS, 0, chrs.length - 1);
        int res = 0;
        for (int answer : answers) {
            if (answer == ans) {
                res += 5;
            } else if (two.contains(answer)) {
                res += 2;
            }
        }
        return res;
    }

    public HashSet<Integer> dfs(char[] chrs, HashSet<Integer>[][] HS, int i, int j) {
        if (HS[i][j] != null)
            return HS[i][j];
        HS[i][j] = new HashSet<>();
        if (i == j) {
            HS[i][j].add(chrs[i] - '0');
            return HS[i][j];
        }
        if (j - i == 1) {
            if (chrs[i + 1] == '+') {
                HS[i][j].add(chrs[i] - '0' + chrs[j] - '0');
                return HS[i][j];
            } else {
                HS[i][j].add((chrs[i] - '0') * (chrs[j] - '0'));
                return HS[i][j];
            }
        }
        HS[i][j] = new HashSet<>();
        for (int k = i; k < j; k += 2) {
            HashSet<Integer> left = dfs(chrs, HS, i, k);
            HashSet<Integer> right = dfs(chrs, HS, k + 2, j);
            if (chrs[k + 1] == '+') {
                for (int l : left) {
                    for (int r : right) {
                        if (l + r <= 1000)
                            HS[i][j].add(l + r);
                    }
                }
            } else {
                for (int l : left) {
                    for (int r : right) {
                        if (l * r <= 1000)
                            HS[i][j].add(l * r);
                    }
                }
            }
        }
        return HS[i][j];
    }

    public int getResult(char[] chrs) {
        int res = 0;
        int prv = chrs[0] - '0';
        for (int i = 1; i < chrs.length; i += 2) {
            if (chrs[i] == '+') {
                res += prv;
                prv = chrs[i + 1] - '0';
            } else {
                prv *= chrs[i + 1] - '0';
            }
        }
        res += prv;
        return res;
    }
}
