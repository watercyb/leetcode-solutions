/*
 * Problem: 1606. Find Servers That Handled Most Number of Requests
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        seg = new int[4 * k];
        int[] counts = new int[k];
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arrival.length; i++) {
            if (seg[0] > arrival[i])
                continue;
            int idx = i % k;
            int tmp = arrival[i] + load[i];
            int server = search(0, k - 1, idx, k - 1, 0, arrival[i]);
            if (server == Integer.MAX_VALUE)
                server = search(0, k - 1, 0, idx - 1, 0, arrival[i]);
            update(0, k - 1, server, 0, tmp);
            counts[server]++;
            if (counts[server] > max) {
                max = counts[server];
                res = new ArrayList<>();
                res.add(server);
            } else if (counts[server] == max) {
                res.add(server);
            }
        }
        return res;
    }

    int[] seg;
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;

    public int update(int l, int r, int i, int idx, int num) {
        if (i >= l && i <= r) {
            if (l != r) {
                int mid = (l + r) >>> 1;
                seg[idx] = Math.min(update(l, mid, i, 2 * idx + 1, num), update(mid + 1, r, i, 2 * idx + 2, num));
            } else {
                seg[idx] = num;
            }
        }
        return seg[idx];
    }

    public int search(int l, int r, int rangeL, int rangeR, int idx, int num) {
        if (rangeR >= l && rangeL <= r && seg[idx] <= num) {
            if (l == r) {
                return l;
            } else {
                int mid = (l + r) >>> 1;
                int tmp = search(l, mid, rangeL, rangeR, 2 * idx + 1, num);
                if (tmp != Integer.MAX_VALUE)
                    return tmp;
                return search(mid + 1, r, rangeL, rangeR, 2 * idx + 2, num);
            }
        }
        return Integer.MAX_VALUE;
    }
}
