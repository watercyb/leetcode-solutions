/*
 * Problem: 3711. Maximum Transactions Without Negative Balance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-transactions-without-negative-balance/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maxTransactions(int[] transactions) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> a - b);
        long sum = 0;
        int res = 0;
        for (int transaction : transactions) {
            sum += transaction;
            if (transaction >= 0) {
                res++;
            } else {
                PQ.offer(transaction);
                while (sum < 0) {
                    sum -= PQ.poll();
                }
            }
        }
        return res + PQ.size();
    }
}
