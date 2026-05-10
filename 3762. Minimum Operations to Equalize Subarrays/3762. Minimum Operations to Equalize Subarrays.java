/*
 * Problem: 3762. Minimum Operations to Equalize Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-equalize-subarrays/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long[] minOperations(int[] nums, int k, int[][] queries) {
        int[] lefts = new int[nums.length];
        int rem = -1;
        int lim = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k != rem) {
                lim = i;
                rem = nums[i] % k;
            }
            lefts[i] = lim;
            max = Math.max(max, nums[i] / k);
            min = Math.min(min, nums[i] / k);
        }
        Node root = dfs(nums, 0, nums.length - 1, k);
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (lefts[right] > left) {
                res[i] = -1;
            } else if (left != right) {
                int l = min;
                int r = max;
                while (l < r) {
                    int mid = (l + r) >>> 1;
                    int diff = chk(root, 0, nums.length - 1, k, left, right, mid) * 2 - (right - left + 1);
                    if (diff >= 1) {
                        r = mid;
                    } else if (diff < 0) {
                        l = mid + 1;
                    } else if (diff == 0) {
                        l = r = mid;
                    }
                }
                res[i] = get(root, 0, nums.length - 1, k, left, right, l);
            }
        }
        return res;
    }

    public long get(Node node, int l, int r, int k, int qL, int qR, int target) {
        if (r < qL || l > qR)
            return 0;
        if (l >= qL && r <= qR)
            return node.getSum(target);
        int mid = (l + r) >>> 1;
        return get(node.left, l, mid, k, qL, qR, target) + get(node.right, mid + 1, r, k, qL, qR, target);
    }

    public int chk(Node node, int l, int r, int k, int qL, int qR, int target) {
        if (r < qL || l > qR)
            return 0;
        if (l >= qL && r <= qR)
            return node.getCount(target);
        int mid = (l + r) >>> 1;
        return chk(node.left, l, mid, k, qL, qR, target) + chk(node.right, mid + 1, r, k, qL, qR, target);
    }

    public Node dfs(int[] nums, int l, int r, int k) {
        if (l == r)
            return new Node(nums[l] % k, nums[l] / k);
        int mid = (l + r) >>> 1;
        Node left = dfs(nums, l, mid, k);
        Node right = dfs(nums, mid + 1, r, k);
        return new Node(left, right);
    }
}

class Node {
    int rem;
    int[] arr;
    long[] sums;
    long sum;
    Node left;
    Node right;

    public Node(int rem, int num) {
        this.rem = rem;
        arr = new int[] { num };
        sums = new long[] { num };
        sum = num;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        if (left.rem != right.rem || left.rem == -1) {
            rem = -1;
            return;
        }
        rem = left.rem;
        arr = new int[left.arr.length + right.arr.length];
        sums = new long[left.arr.length + right.arr.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        long sum = 0;
        while (i < left.arr.length && j < right.arr.length) {
            if (left.arr[i] < right.arr[j]) {
                arr[idx] = left.arr[i++];
                sum += arr[idx];
                sums[idx++] = sum;
            } else if (left.arr[i] > right.arr[j]) {
                arr[idx] = right.arr[j++];
                sum += arr[idx];
                sums[idx++] = sum;
            } else {
                arr[idx] = left.arr[i++];
                sum += arr[idx];
                sums[idx++] = sum;
                arr[idx] = right.arr[j++];
                sum += arr[idx];
                sums[idx++] = sum;
            }
        }
        while (i < left.arr.length) {
            arr[idx] = left.arr[i++];
            sum += arr[idx];
            sums[idx++] = sum;
        }
        while (j < right.arr.length) {
            arr[idx] = right.arr[j++];
            sum += arr[idx];
            sums[idx++] = sum;
        }
        this.sum = left.sum + right.sum;
    }

    public int getCount(int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public long getSum(int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == 0) {
            return sum - (long) target * arr.length;
        } else if (l == arr.length) {
            return (long) target * arr.length - sum;
        } else {
            return (long) target * l - sums[l - 1] + sum - sums[l - 1] - (long) target * (arr.length - l);
        }
    }
}
