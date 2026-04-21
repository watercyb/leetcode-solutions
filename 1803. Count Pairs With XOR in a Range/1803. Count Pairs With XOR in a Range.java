/*
 * Problem: 1803. Count Pairs With XOR in a Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-pairs-with-xor-in-a-range/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int lim = (int) Math.ceil(Math.log(20000) / Math.log(2)) - 1;
        TrieNode root = new TrieNode();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = count(root, nums[i], lim, high) - count(root, nums[i], lim, low - 1);
            res += sum;
            insert(root, nums[i], lim);
        }
        return res;
    }

    public int count(TrieNode node, int num, int i, int lim) {
        int res = 0;
        int sum = 0;
        while (i >= 0 && sum <= lim && node != null) {
            int base = 1 << i;
            if ((num & base) != 0) {
                if (sum + base - 1 <= lim) {
                    if (node.one != null)
                        res += node.one.count;
                    sum += base;
                    node = node.zero;
                } else {
                    node = node.one;
                }
            } else {
                if (sum + base - 1 <= lim) {
                    if (node.zero != null)
                        res += node.zero.count;
                    sum += base;
                    node = node.one;
                } else {
                    node = node.zero;
                }
            }
            i--;
        }
        return res;
    }

    public void insert(TrieNode node, int num, int n) {
        for (int i = n; i >= 0; i--) {
            node.count++;
            if ((num & (1 << i)) != 0) {
                if (node.one == null)
                    node.one = new TrieNode();
                node = node.one;
            } else {
                if (node.zero == null)
                    node.zero = new TrieNode();
                node = node.zero;
            }
        }
        node.count++;
    }
}

class TrieNode {
    TrieNode zero;
    TrieNode one;
    int count = 0;
}
