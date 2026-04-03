/*
 * Problem: 386. Lexicographical Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographical-numbers/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            if (!dfs(i, n))
                break;
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public boolean dfs(int num, int n) {
        if (num <= n) {
            res.add(num);
            num *= 10;
            for (int i = 0; i < 10; i++) {
                if (!dfs(num + i, n))
                    break;
            }
            return true;
        }
        return false;
    }
}
