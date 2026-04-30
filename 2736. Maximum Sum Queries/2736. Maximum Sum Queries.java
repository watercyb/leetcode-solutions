/*
 * Problem: 2736. Maximum Sum Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-sum-queries/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        Node[] nodes = new Node[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nodes[i] = new Node(nums1[i], nums2[i]);
        }
        Arrays.sort(nodes);
        Node[] q = new Node[queries.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = new Node(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(q);
        Node[] arr = new Node[nums1.length];
        int idx = 0;
        int[] res = new int[q.length];
        int j = 0;
        for (int i = 0; i < q.length; i++) {
            int x = q[i].x;
            int y = q[i].y;
            while (j < nodes.length && nodes[j].x >= x) {
                while (idx > 0 && nodes[j].y >= arr[idx - 1].y && nodes[j].sum >= arr[idx - 1].sum) {
                    idx--;
                }
                if (idx == 0 || nodes[j].y > arr[idx - 1].y)
                    arr[idx++] = nodes[j];
                j++;
            }
            res[q[i].idx] = getIdx(arr, idx, y);
        }
        return res;
    }

    public int getIdx(Node[] arr, int idx, int target) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid].y >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == idx)
            return -1;
        return arr[l].sum;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int sum;
    int idx;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        sum = x + y;
    }

    public Node(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }

    public int compareTo(Node node) {
        return node.x - this.x;
    }
}
