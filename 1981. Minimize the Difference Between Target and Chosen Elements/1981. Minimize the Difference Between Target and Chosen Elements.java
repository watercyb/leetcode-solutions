/*
 * Problem: 1981. Minimize the Difference Between Target and Chosen Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Node node = new Node();
        node.arr[0] = 1;
        for (int[] row : mat) {
            Node nodeNext = new Node();
            HashSet<Integer> HS = new HashSet<>();
            for (int num : row) {
                if (HS.add(num))
                    nodeNext.OR(node.move(num));
            }
            node = nodeNext;
        }
        int res = 0;
        while (true) {
            if ((target - res >= 0 && node.has(target - res)) || node.has(target + res))
                return res;
            res++;
        }
    }
}

class Node {
    long[] arr = new long[77];

    public Node move(int n) {
        Node res = new Node();
        res.arr = arr.clone();
        int m = n % 64;
        long prv = 0;
        long mask = (1l << (64 - m)) - 1;
        if (m > 0) {
            for (int i = 0; i < arr.length; i++) {
                long prvNext = res.arr[i] >>> (64 - m);
                res.arr[i] = ((res.arr[i] & mask) << m) + prv;
                prv = prvNext;
            }
        }
        n /= 64;
        if (n > 0) {
            for (int i = arr.length - 1; i >= n; i--) {
                res.arr[i] = res.arr[i - n];
            }
            for (int i = 0; i < n; i++) {
                res.arr[i] = 0;
            }
        }
        return res;
    }

    public void OR(Node node) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] |= node.arr[i];
        }
    }

    public boolean has(int n) {
        return (arr[n / 64] & (1l << (n % 64))) != 0;
    }
}
