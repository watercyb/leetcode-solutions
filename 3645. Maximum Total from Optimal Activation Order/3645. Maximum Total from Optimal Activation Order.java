/*
 * Problem: 3645. Maximum Total from Optimal Activation Order
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-from-optimal-activation-order/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maxTotal(int[] value, int[] limit) {
        List<Integer>[] lists = new ArrayList[limit.length + 1];
        for (int i = 0; i < value.length; i++) {
            if (lists[limit[i]] == null)
                lists[limit[i]] = new ArrayList<>();
            lists[limit[i]].add(value[i]);
        }
        long res = 0;
        for (int i = 1; i <= value.length; i++) {
            if (lists[i] != null) {
                Collections.sort(lists[i]);
                for (int j = lists[i].size() - 1; j >= Math.max(lists[i].size() - i, 0); j--) {
                    res += lists[i].get(j);
                }
            }
        }
        return res;
    }
}
