/*
 * Problem: 3989. Maximum Consistent Columns in a Grid
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-consistent-columns-in-a-grid/
 * Language: java
 * Date: 2026-07-17
 */

class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
                min = Math.min(min, grid[i][j]);
            }
        }
        Node[] nodes = new Node[grid[0].length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(Long.MAX_VALUE);
        }
        for (int i = 0; i < grid.length; i++) {
            BIT bit = new BIT(min, max);
            boolean isZero = true;
            for (int j = 0; j < grid[0].length; j++) {
                int l = grid[i][j] - limit;
                int r = grid[i][j] + limit;
                Node node = bit.get(l - 1).xor(bit.get(r));
                nodes[j].and(node);
                bit.insert(grid[i][j], j);
                if (!nodes[j].isZero())
                    isZero = false;
            }
            if (isZero)
                return 1;
        }
        //for (int i = 0; i < grid[0].length; i++) {
        //System.out.println(nodes[i]);
        //}
        int[] lens = new int[grid[0].length];
        int res = 0;
        for (int i = 0; i < nodes.length; i++) {
            int len = 0;
            for (int idx : nodes[i].getList()) {
                len = Math.max(len, lens[idx]);
            }
            lens[i] = len + 1;
            res = Math.max(res, lens[i]);
        }
        return res;
    }
}

class Node {
    long[] arr = new long[4];

    public Node() {
    }

    public Node(long n) {
        Arrays.fill(arr, n);
    }

    public void insert(int i) {
        arr[i / 63] |= 1l << (i % 63);
    }

    public Node xor(Node node) {
        Node res = new Node();
        for (int i = 0; i < 4; i++) {
            res.arr[i] = arr[i] ^ node.arr[i];
        }
        return res;
    }

    public void or(Node node) {
        for (int i = 0; i < 4; i++) {
            arr[i] = arr[i] | node.arr[i];
        }
    }

    public void and(Node node) {
        for (int i = 0; i < 4; i++) {
            arr[i] = arr[i] & node.arr[i];
        }
    }

    public List<Integer> getList() {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 63; j++) {
                if ((arr[i] & (1l << j)) != 0)
                    res.add(i * 63 + j);
            }
        }
        return res;
    }

    public boolean isZero() {
        return arr[0] + arr[1] + arr[2] + arr[3] == 0;
    }

    public String toString() {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 63; j++) {
                if ((arr[i] & (1l << j)) != 0)
                    SB.append(i * 63 + j).append(' ');
            }
        }
        return SB.toString();
    }
}

class BIT {
    Node[] bit;
    int offset;

    public BIT(int l, int r) {
        bit = new Node[r - l + 2];
        offset = -l;
        for (int i = 0; i < bit.length; i++) {
            bit[i] = new Node();
        }
    }

    public void insert(int i, int n) {
        i += offset + 1;
        while (i < bit.length) {
            bit[i].insert(n);
            i += i & -i;
        }
    }

    public Node get(int i) {
        i += offset + 1;
        if (i >= bit.length)
            i = bit.length - 1;
        Node res = new Node();
        while (i > 0) {
            res.or(bit[i]);
            i -= i & -i;
        }
        return res;
    }
}
