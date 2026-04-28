/*
 * Problem: 2509. Cycle Length Queries in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cycle-length-queries-in-a-tree/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res=new int[queries.length];
        for (int i=0;i<queries.length;i++) {
            int a=queries[i][0];
            int b=queries[i][1];
            while (a!=b) {
                res[i]++;
                if (a>b) {
                    a/=2;
                } else {
                    b/=2;
                }
            }
            res[i]++;          
        }
        return res;
    }
}
