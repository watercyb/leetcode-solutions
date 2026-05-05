/*
 * Problem: 3266. Final Array State After K Multiplication Operations II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    int mod = 1_000_000_007;

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1)
            return nums;
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i], i);
        }
        while (k > 0) {
            Arrays.sort(nodes, (a, b) -> a.num == b.num ? a.idx - b.idx : Long.compare(a.num, b.num));
            int i = 1;
            while (i < nums.length && nodes[0].num * multiplier > nodes[i].num) {
                i++;
            }
            if (i == nums.length) {
                calWithMod(nodes, k % nums.length, k / nums.length, nums.length - 1, multiplier);
                break;
            } else {
                double diff = (double) nodes[i].num / nodes[i - 1].num;
                int n = (int) Math.ceil(Math.log(diff) / Math.log(multiplier));
                if (n * i >= k) {
                    calWithMod(nodes, k % i, k / i, i - 1, multiplier);
                    break;
                }
                k -= n * i;
                cal(nodes, 0, n, i - 1, multiplier);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            nums[nodes[i].idx] = (int) nodes[i].num;
        }
        return nums;
    }

    public void calWithMod(Node[] nodes, int k, int n, int lim, int multiplier) {
        if (n > 0) {
            int x = pow(multiplier, n);
            for (int i = 0; i <= lim; i++) {
                nodes[i].num = nodes[i].num % mod * x % mod;
            }
        }
        for (int i = 0; i < k; i++) {
            nodes[i].num = nodes[i].num * multiplier % mod;
        }
    }

    public void cal(Node[] nodes, int k, int n, int lim, int multiplier) {
        if (n > 0) {
            long x = (long) Math.pow(multiplier, n);
            for (int i = 0; i <= lim; i++) {
                nodes[i].num = nodes[i].num * x;
            }
        }
        for (int i = 0; i < k; i++) {
            nodes[i].num = nodes[i].num * multiplier;
        }
    }

    public int pow(long num, int n) {
        long res = 1;
        long x = num;
        while (n > 0) {
            if (n % 2 == 1)
                res = res * x % mod;
            x = x * x % mod;
            n /= 2;
        }
        return (int) res;
    }
}

class Node {
    long num;
    int idx;

    public Node(long num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}
