/*
 * Problem: 3515. Shortest Path in a Weighted Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/shortest-path-in-a-weighted-tree/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        List<Node>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new Node(edge[1], edge[2]));
            lists[edge[1]].add(new Node(edge[0], edge[2]));
        }
        nums = new int[n + 1];
        bit = new BIT(2 * n + 1);
        levels = new int[n + 1];
        lefts = new int[n + 1];
        rights = new int[n + 1];
        dfs(lists, 1, 0, 0, 0);
        int count = 0;
        for (int[] query : queries) {
            if (query[0] == 2)
                count++;
        }
        int[] res = new int[count];
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                int num = levels[query[1]] > levels[query[2]] ? query[1] : query[2];
                if (nums[num] == query[3])
                    continue;
                bit.insert(lefts[num], rights[num], query[3] - nums[num]);
                nums[num] = query[3];
            } else {
                res[idx++] = bit.get(lefts[query[1]]);
            }
        }
        return res;
    }

    int[] nums;
    int idx = 0;
    int[] levels;
    int[] lefts;
    int[] rights;
    BIT bit;

    public void dfs(List<Node>[] lists, int i, int prv, int w, int lv) {
        nums[i] = w;
        bit.insert(idx, w);
        levels[i] = lv;
        lefts[i] = idx++;
        for (Node node : lists[i]) {
            if (node.idx == prv)
                continue;
            dfs(lists, node.idx, i, node.w, lv + 1);
        }
        bit.insert(idx, -w);
        rights[i] = idx++;
    }
}

class BIT {
    int[] BIT;

    public BIT(int n) {
        BIT = new int[n];
    }

    public void insert(int i, int j, int num) {
        insert(i, num);
        insert(j, -num);
    }

    public void insert(int i, int num) {
        i++;
        while (i < BIT.length) {
            BIT[i] += num;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}

class Node {
    int idx;
    int w;

    public Node(int idx, int w) {
        this.idx = idx;
        this.w = w;
    }
}
