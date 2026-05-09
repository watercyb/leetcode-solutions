/*
 * Problem: 3632. Subarrays with XOR at Least K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subarrays-with-xor-at-least-k/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long countXorSubarrays(int[] nums, int k) {
        int max = k;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int n = 32 - Integer.numberOfLeadingZeros(max);
        int[] counts = new int[n];
        Node root = new Node();
        int[] target = getArr(k, n);
        long res = 0;
        for (int num : nums) {
            insert(root, counts);
            int idx = n - 1;
            while (num > 0) {
                counts[idx] ^=num & 1;
                num >>= 1;
                idx--;
            }
            res += get(root, counts, target, n);
        }
        return res;
    }

    private int[] getArr(int num, int len) {
        int[] res = new int[len];
        int idx = len - 1;
        while (num > 0) {
            res[idx] = num & 1;
            num >>= 1;
            idx--;
        }
        return res;
    }

    private void insert(Node node, int[] arr) {
        for (int digit : arr) {
            if (node.next[digit] == null)
                node.next[digit] = new Node();
            node.count++;
            node = node.next[digit];
        }
        node.count++;
    }

    private int get(Node node, int[] arr, int[] target, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (target[i] == 0) {
                int idx = 1 - arr[i];
                if (node.next[idx] != null)
                    res += node.next[idx].count;
                if (node.next[arr[i]] == null)
                    return res;
                node = node.next[arr[i]];
            } else {
                int idx = 1 - arr[i];
                if (node.next[idx] == null)
                    return res;
                node = node.next[idx];
            }
        }
        return res + node.count;
    }
}

class Node {
    Node[] next = new Node[2];
    int count = 0;
}
