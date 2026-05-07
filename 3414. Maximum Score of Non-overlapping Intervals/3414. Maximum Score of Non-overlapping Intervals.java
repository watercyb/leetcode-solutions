/*
 * Problem: 3414. Maximum Score of Non-overlapping Intervals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int[][] arr = new int[intervals.size()][4];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = intervals.get(i);
            for (int j = 0; j < 3; j++) {
                arr[i][j] = list.get(j);
            }
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        Node[] DP = new Node[arr.length + 1];
        DP[0] = new Node(0);
        int DPIdx = 1;
        for (int i = 0; i < arr.length; i++) {
            int l = arr[i][0];
            int r = arr[i][1];
            int w = arr[i][2];
            int arrIdx = arr[i][3];
            Node node = null;
            if (DP[DPIdx - 1].idx == r) {
                node = DP[DPIdx - 1];
            } else {
                node = DP[DPIdx - 1].clone();
                DP[DPIdx++] = node;
            }
            node.idx = r;
            Node prvNode = DP[binarySearch(DP, l, DPIdx)];
            for (int j = 1; j <= 3; j++) {
                if (node.sum[j] < prvNode.sum[j - 1] + w) {
                    node.insert(prvNode, j - 1, w, arrIdx);
                } else if (node.sum[j] == prvNode.sum[j - 1] + w) {
                    int[] arrTemp = insertToArr(prvNode.arr[j - 1], arrIdx);
                    if (arrCmp(node.arr[j], arrTemp))
                        node.arr[j] = arrTemp;
                }
            }
            if (node.sum[0] < w || (node.sum[0] == w && node.arr[0][0] > arrIdx)) {
                node.sum[0] = w;
                node.arr[0][0] = arrIdx;
            }
        }
        Node node = DP[DPIdx - 1];
        int idx = 0;
        for (int j = 1; j <= 3; j++) {
            if (node.sum[j] > node.sum[idx] || (node.sum[j] == node.sum[idx] && arrCmp(node.arr[idx], node.arr[j])))
                idx = j;
        }
        int[] res = new int[node.arr[idx].length];
        for (int j = 0; j < res.length; j++) {
            res[j] = node.arr[idx][j];
        }
        return res;
    }

    public int binarySearch(Node[] DP, int i, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid].idx >= i) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public int[] insertToArr(int[] arr, int idx) {
        int[] res = new int[arr.length + 1];
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (j < arr.length && arr[j] < idx) {
                res[i] = arr[j];
                j++;
            } else {
                res[i] = idx;
                idx = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    public boolean arrCmp(int[] a, int[] b) {
        int lim = Math.min(a.length, b.length);
        for (int i = 0; i < lim; i++) {
            if (a[i] > b[i]) {
                return true;
            } else if (a[i] < b[i]) {
                return false;
            }
        }
        return false;
    }
}

class Node {
    int[][] arr;
    long[] sum;
    int idx;

    public Node(int idx) {
        arr = new int[][] { { Integer.MAX_VALUE }, { Integer.MAX_VALUE, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } };
        sum = new long[] { 0, 0, 0, 0 };
        this.idx = idx;
    }

    public Node(int[][] arr, long[] sum, int idx) {
        this.arr = new int[4][];
        for (int i = 0; i < 4; i++) {
            this.arr[i] = arr[i].clone();
        }
        this.sum = sum.clone();
        this.idx = idx;
    }

    public Node clone() {
        return new Node(arr, sum, idx);
    }

    public void insert(Node prvNode, int i, int point, int idx) {
        int k = 0;
        for (int j = 0; j < arr[i + 1].length; j++) {
            if (k < prvNode.arr[i].length && prvNode.arr[i][k] < idx) {
                arr[i + 1][j] = prvNode.arr[i][k];
                k++;
            } else {
                arr[i + 1][j] = idx;
                idx = Integer.MAX_VALUE;
            }
        }
        sum[i + 1] = prvNode.sum[i] + point;
    }
}
