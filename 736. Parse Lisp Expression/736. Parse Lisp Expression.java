/*
 * Problem: 736. Parse Lisp Expression
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/parse-lisp-expression/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int evaluate(String expression) {
        chrs = expression.toCharArray();
        return dfs(new HashMap<>());
    }

    char[] chrs;
    int idx = 0;

    public int dfs(HashMap<String, Integer> HM) {
        if (chrs[idx] == '(')
            idx++;
        if (chrs[idx] == 'l') {
            idx += 4;
            HashMap<String, Integer> HMNext = new HashMap<>();
            HMNext.putAll(HM);
            String v = "";
            int res = Integer.MAX_VALUE;
            while (chrs[idx] != ')') {
                if (Character.isDigit(chrs[idx]) || chrs[idx] == '-') {
                    int num = getNum();
                    if (v.isEmpty()) {
                        res = num;
                    } else {
                        HMNext.put(v, num);
                        v = "";
                        res = num;
                    }
                } else if (Character.isLetter(chrs[idx])) {
                    String str = getStr();
                    if (v.isEmpty()) {
                        v = str;
                    } else {
                        HMNext.put(v, HMNext.get(str));
                    }
                } else if (chrs[idx] == '(') {
                    int num = dfs(HMNext);
                    if (v.isEmpty()) {
                        res = num;
                    } else {
                        HMNext.put(v, num);
                        v = "";
                        res = num;
                    }
                } else {
                    idx++;
                }
            }
            idx++;
            return res;
        } else if (chrs[idx] == 'a') {
            idx += 4;
            int res = 0;
            while (chrs[idx] != ')') {
                if (Character.isDigit(chrs[idx]) || chrs[idx] == '-') {
                    res += getNum();
                } else if (Character.isLetter(chrs[idx])) {
                    res += HM.get(getStr());
                } else if (chrs[idx] == '(') {
                    res += dfs(HM);
                } else {
                    idx++;
                }
            }
            idx++;
            return res;
        } else {
            idx += 5;
            int res = 1;
            while (chrs[idx] != ')') {
                if (Character.isDigit(chrs[idx]) || chrs[idx] == '-') {
                    res *= getNum();
                } else if (Character.isLetter(chrs[idx])) {
                    res *= HM.get(getStr());
                } else if (chrs[idx] == '(') {
                    res *= dfs(HM);
                } else {
                    idx++;
                }
            }
            idx++;
            return res;
        }
    }

    public int getNum() {
        int res = 0;
        int p = 1;
        if (chrs[idx] == '-') {
            p = -1;
            idx++;
        }
        while (Character.isDigit(chrs[idx])) {
            res = res * 10 + chrs[idx++] - '0';
        }
        return res * p;
    }

    public String getStr() {
        StringBuilder SB = new StringBuilder();
        while (Character.isLetter(chrs[idx]) || Character.isDigit(chrs[idx])) {
            SB.append(chrs[idx++]);
        }
        return SB.toString();
    }
}
