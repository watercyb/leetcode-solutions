/*
 * Problem: 77. Combinations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/combinations/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] res = new int[k];
        combining(res, n, k, 0);
        return Li;
    }

    List<List<Integer>> Li = new ArrayList<>();

    public void combining(int[] res, int n, int k, int m) {
        if (m > 0)
            res[k] = m;
        if (k == 0) {
            List<Integer> re=new ArrayList<>();
            for (int in:res) re.add(in);
            Li.add(re);
            return;
        }
        for (int i = m + 1; i <= n; i++) {
            if (n - i + 1 < k)
                break;
            combining(res, n, k - 1, i);
        }
    }


}
