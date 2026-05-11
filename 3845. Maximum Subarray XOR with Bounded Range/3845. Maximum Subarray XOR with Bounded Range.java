/*
 * Problem: 3845. Maximum Subarray XOR with Bounded Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-subarray-xor-with-bounded-range/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int maxXor(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int len = 31 - Integer.numberOfLeadingZeros(max);
        int[] maxs = new int[nums.length];
        int lMax = 0;
        int rMax = 0;
        int[] mins = new int[nums.length];
        int lMin = 0;
        int rMin = 0;
        int j = 0;
        int res = 0;
        Node root = new Node();
        int[] xors = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                if (lMax == rMax
                        || Math.max(Math.abs(nums[maxs[lMax]] - nums[j]),
                                Math.abs(nums[j] - nums[mins[lMin]])) <= k) {
                    while (lMax < rMax && nums[maxs[rMax - 1]] <= nums[j]) {
                        rMax--;
                    }
                    maxs[rMax++] = j;
                    while (lMin < rMin && nums[mins[rMin - 1]] >= nums[j]) {
                        rMin--;
                    }
                    mins[rMin++] = j;
                    xors[j + 1] = xors[j] ^ nums[j];
                    insert(root, xors[j + 1], len);
                    j++;
                } else {
                    break;
                }
            }
            res = Math.max(res, getMax(root, xors[i], len));
            remove(root, xors[i + 1], len);
            while (lMax < rMax && maxs[lMax] <= i) {
                lMax++;
            }
            while (lMin < rMin && mins[lMin] <= i) {
                lMin++;
            }
        }
        return res;
    }

    public int getMax(Node root, int pre, int len) {
        int res = 0;
        while (len >= 0) {
            res <<= 1;
            int idx = 1 - ((pre >> len) & 1);
            if (root.next[idx] != null) {
                root = root.next[idx];
                res++;
            } else {
                root = root.next[1 - idx];
            }
            len--;
        }
        return res;
    }

    public void insert(Node root, int num, int len) {
        while (len >= 0) {
            int idx = (num >> len) & 1;
            if (root.next[idx] == null)
                root.next[idx] = new Node();
            root = root.next[idx];
            root.count++;
            len--;
        }
    }

    public void remove(Node root, int num, int len) {
        while (len >= 0) {
            int idx = (num >> len) & 1;
            if (root.next[idx].count == 1) {
                root.next[idx] = null;
                break;
            }
            root = root.next[idx];
            root.count--;
            len--;
        }
    }
}

class Node {
    Node[] next = new Node[2];
    int count = 0;
}
