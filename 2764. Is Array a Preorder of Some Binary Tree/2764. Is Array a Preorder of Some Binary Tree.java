/*
 * Problem: 2764. Is Array a Preorder of Some ‌Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/is-array-a-preorder-of-some-binary-tree/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public boolean isPreorder(List<List<Integer>> nodes) {
        Deque<Integer> Dq = new ArrayDeque<>();
        List<Integer> list = nodes.getFirst();
        if (list.get(1) != -1)
            return false;
        Dq.offerLast(list.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            list = nodes.get(i);
            int a = list.get(0);
            int b = list.get(1);
            while (!Dq.isEmpty() && Dq.peekLast() != b) {
                Dq.pollLast();
            }
            if (Dq.isEmpty())
                return false;
            Dq.offerLast(a);
        }
        return true;
    }
}
