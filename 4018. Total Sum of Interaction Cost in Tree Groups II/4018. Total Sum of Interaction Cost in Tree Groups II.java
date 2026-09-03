/*
 * Problem: 4018. Total Sum of Interaction Cost in Tree Groups II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/total-sum-of-interaction-cost-in-tree-groups-ii/
 * Language: java
 * Date: 2026-09-03
 */

class Solution {
    public long interactionCosts(int n, int[][] edges, int[] group) {
        if (n == 1)
            return 0;
        int[] sort = group.clone();
        Arrays.sort(sort);
        int prv = -1;
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int num : sort) {
            if (num != prv) {
                HM.put(num, HM.size());
                prv = num;
            }
        }
        int[] counts = new int[HM.size()];
        for (int i = 0; i < group.length; i++) {
            group[i] = HM.get(group[i]);
            counts[group[i]]++;
        }
        lists = new ArrayList[counts.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        int[][] links = getLinks(edges, n);
        int m = 32 - Integer.numberOfLeadingZeros(n - 1);
        BLT = new int[n][m];
        depth = new int[n];
        tin = new int[n];
        dfs(links, group, 0, 0, 0);
        fill();
        for (List<Integer> list : lists) {
            getVT(list, counts, group);
        }
        return res;
    }

    int[][] BLT;
    int[] depth;
    int[] tin;
    int t = 0;
    long res = 0;
    int idx = 0;
    List<Integer>[] lists;

    public void getVT(List<Integer> list, int[] counts, int[] group) {
        if (list.size() == 1)
            return;
        if (list.size() == 2) {
            int a = list.get(0);
            int b = list.get(1);
            int lca = LCA(a, b);
            res += depth[a] + depth[b] - 2 * depth[lca];
            return;
        }
        int g = group[list.get(0)];
        for (int i = list.size() - 2; i >= 0; i--) {
            int a = list.get(i);
            int b = list.get(i + 1);
            int lca = LCA(a, b);
            if (group[lca] != g)
                list.add(lca);
        }
        //{i, t, g}
        list.sort((a, b) -> tin[a] - tin[b]);
        int count = 0;
        int prv = -1;
        for (int i = 0; i < list.size(); i++) {
            int idx = list.get(i);
            if (idx == prv)
                count++;
            prv = idx;
        }
        int[] arr = new int[list.size() - count];
        int index = 0;
        prv = -1;
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current != prv)
                arr[index++] = current;
            prv = current;
        }
        this.idx = 0;
        dfs(arr, group, counts[g], g);
    }

    public int dfs(int[] arr, int[] groups, int count, int group) {
        int index = arr[idx++];
        int g = groups[index];
        int sum = g == group ? 1 : 0;
        while (idx < arr.length && LCA(index, arr[idx]) == index) {
            int l = depth[arr[idx]] - depth[index];
            int c = dfs(arr, groups, count, group);
            res += (long) l * c * (count - c);
            sum += c;
        }
        return sum;
    }

    public void dfs(int[][] links, int[] group, int i, int prv, int lv) {
        BLT[i][0] = prv;
        depth[i] = lv;
        tin[i] = t++;
        lists[group[i]].add(i);
        for (int next : links[i]) {
            if (next == prv)
                continue;
            dfs(links, group, next, i, lv + 1);
        }
    }

    public void fill() {
        for (int i = 1; i < BLT[0].length; i++) {
            for (int j = 0; j < BLT.length; j++) {
                int idx = BLT[j][i - 1];
                BLT[j][i] = BLT[idx][i - 1];
            }
        }
    }

    public int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = BLT[0].length - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = BLT[u][i];
            }
        }
        if (u == v)
            return u;
        for (int i = BLT[0].length - 1; i >= 0; i--) {
            if (BLT[u][i] != BLT[v][i]) {
                u = BLT[u][i];
                v = BLT[v][i];
            }
        }
        return BLT[u][0];
    }

    public int[][] getLinks(int[][] edges, int n) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = edge[1];
            links[edge[1]][--counts[edge[1]]] = edge[0];
        }
        return links;
    }
}
