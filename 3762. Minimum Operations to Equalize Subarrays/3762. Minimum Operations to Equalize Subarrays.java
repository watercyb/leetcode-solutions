/*
 * Problem: 3762. Minimum Operations to Equalize Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-equalize-subarrays/
 * Language: java
 * Date: 2026-07-18
 */

class Solution {
    public long[] minOperations(int[] nums, int k, int[][] queries) {
        int[] indexes = new int[nums.length];
        int[][] ranges = new int[nums.length][];
        int idx = -1;
        int rem = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int prv = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k != rem) {
                rem = nums[i] % k;
                if (idx >= 0) {
                    ranges[idx] = new int[] { prv, i - 1 };
                }
                prv = i;
                idx++;
            }
            indexes[i] = idx;
            nums[i] /= k;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        ranges[idx] = new int[] { prv, nums.length - 1 };
        long[] res = new long[queries.length];
        PerSeg PS = null;
        int[] currentRange = new int[] { -1, -1 };
        int[][] arr = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            arr[i] = new int[] { queries[i][0], queries[i][1], i };
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) {
            int left = arr[i][0];
            int right = arr[i][1];
            idx = arr[i][2];
            if (indexes[left] != indexes[right]) {
                res[idx] = -1;
            } else if (left != right) {
                int[] range = ranges[indexes[left]];
                if (range[0] != currentRange[0]) {
                    currentRange = range;
                    PS = new PerSeg(nums, currentRange[0], currentRange[1]);
                }
                res[idx] = PS.getMin(left, right);
            }
        }
        return res;
    }

}

class PerSeg {
    int offset;
    Node[] nodes;
    long[] sums;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public PerSeg(int[] nums, int l, int r) {
        offset = l;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        nodes = new Node[r - l + 2];
        nodes[0] = new Node();
        sums = new long[r - l + 2];
        for (int i = l; i <= r; i++) {
            nodes[i - l + 1] = insert(nodes[i - l], min, max, nums[i]);
            sums[i - l + 1] = sums[i - l] + nums[i];
        }
    }

    public Node insert(Node node, int l, int r, int num) {
        Node res = new Node(node);
        res.count++;
        res.sum += num;
        if (l == r)
            return res;
        int mid = (l + r) >>> 1;
        if (num <= mid) {
            if (node.left == null)
                node.left = new Node();
            res.left = insert(node.left, l, mid, num);
        } else {
            if (node.right == null)
                node.right = new Node();
            res.right = insert(node.right, mid + 1, r, num);
        }
        return res;
    }

    public Pair<Integer, Long> getMidPair(Node node, Node prv, int l, int r, int i) {
        if (node == null)
            return new Pair<>(0, 0l);
        int countLeft = (node.left == null ? 0 : node.left.count)
                - (prv == null ? 0 : (prv.left == null ? 0 : prv.left.count));
        int mid = (l + r) >>> 1;
        if (i <= mid) {
            return getMidPair(node.left, prv == null ? null : prv.left, l, mid, i);
        } else {
            Pair<Integer, Long> pair = getMidPair(node.right, prv == null ? null : prv.right, mid + 1, r, i);
            return new Pair<>(pair.getKey() + countLeft, pair.getValue() + (node.left == null ? 0 : node.left.sum)
                    - (prv == null ? 0 : (prv.left == null ? 0 : prv.left.sum)));
        }
    }

    public int getMidIdx(Node node, Node prv, int l, int r, int target) {
        if (l == r)
            return l;
        int countLeft = (node.left == null ? 0 : node.left.count)
                - (prv == null ? 0 : (prv.left == null ? 0 : prv.left.count));
        int mid = (l + r) >>> 1;
        if (countLeft >= target) {
            return getMidIdx(node.left, prv == null ? null : prv.left, l, mid, target);
        } else {
            return getMidIdx(node.right, prv == null ? null : prv.right, mid + 1, r, target - countLeft);
        }
    }

    public long getMin(int left, int right) {
        left -= offset;
        right -= offset;
        int len = right - left + 1;
        int num = getMidIdx(nodes[right + 1], nodes[left], min, max, (len + 1) / 2);
        Pair<Integer, Long> pair = getMidPair(nodes[right + 1], nodes[left], min, max, num);
        long leftSum = pair.getValue();
        long rightSum = sums[right + 1] - sums[left] - leftSum;
        int leftCount = pair.getKey();
        int rightCount = len - leftCount;
        return (long) leftCount * num - leftSum + rightSum - (long) rightCount * num;
    }

    class Node {
        int count = 0;
        long sum = 0;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Node node) {
            count = node.count;
            sum = node.sum;
            left = node.left;
            right = node.right;
        }
    }
}

