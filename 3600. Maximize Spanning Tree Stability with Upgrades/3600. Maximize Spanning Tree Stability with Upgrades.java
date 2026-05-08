/*
 * Problem: 3600. Maximize Spanning Tree Stability with Upgrades
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int min = Integer.MAX_VALUE - 1;
        int count1 = 0;
        int count2 = 0;
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                int a = find(links, edge[0]);
                int b = find(links, edge[1]);
                if (a == b)
                    return -1;
                links[a] = b;
                min = Math.min(edge[2], min);
                count1++;
            } else {
                count2++;
            }
        }
        if (count1 == n - 1)
            return min;
        int[][] arr = new int[count2][];
        int idx = 0;
        for (int[] edge : edges) {
            if (edge[3] != 1) {
                arr[idx] = new int[] { edge[0], edge[1], edge[2] };
                idx++;
            }
        }
        arr = sort(arr);
        int l = 0;
        int r = min + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(arr, links, mid, k, count1)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public int[][] sort(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i][2], max);
        }
        int[] counts = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i][2]]++;
        }
        for (int i = 1; i <= max; i++) {
            counts[i] += counts[i - 1];
        }
        int[][] res = new int[arr.length][];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[--counts[arr[i][2]]] = arr[i];
        }
        return res;
    }

    public boolean chk(int[][] arr, int[] links, int mid, int k, int n) {
        links = links.clone();
        for (int i = binarySearch(arr, mid); i < arr.length; i++) {
            int a = find(links, arr[i][0]);
            int b = find(links, arr[i][1]);
            if (a != b) {
                links[a] = b;
                if (++n == links.length - 1)
                    return true;
            }
        }
        for (int i = binarySearch(arr, (mid + 1) / 2); i < arr.length && k > 0; i++) {
            int a = find(links, arr[i][0]);
            int b = find(links, arr[i][1]);
            if (a != b) {
                links[a] = b;
                k--;
                if (++n == links.length - 1)
                    return true;
            }
        }
        return false;
    }

    public int binarySearch(int[][] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid][2] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public int[][] listToArr(List<int[]> list) {
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
