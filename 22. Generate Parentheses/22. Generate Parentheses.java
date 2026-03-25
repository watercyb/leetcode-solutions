/*
 * Problem: 22. Generate Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/generate-parentheses/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if (n==0) return res;
        DFS(new StringBuilder(),res,n,n);
        return res;
    }

    public void DFS(StringBuilder SB, List<String> res, int n1, int n2) {
        if (n1==0&&n2==0) {
            res.add(SB.toString());
        }
        if (n1>0) {
            SB.append('(');
            DFS(SB, res, n1-1, n2);
            SB.deleteCharAt(SB.length()-1);
        }
        if (n2>n1) {
            SB.append(')');
            DFS(SB, res, n1, n2-1);
            SB.deleteCharAt(SB.length()-1);
        }
    }
}
