/*
 * Problem: 1203. Sort Items by Groups Respecting Dependencies
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<Integer>[] links = new ArrayList[n];
        List<Integer>[] groups = new ArrayList[m];
        int[] countsItem = new int[n];
        int[] countsGroup = new int[m];
        for (int i = 0; i < m; i++) {
            groups[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
            if (group[i] >= 0) {
                groups[group[i]].add(i);
            }
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> list = beforeItems.get(i);
            for (int before : list) {
                links[before].add(i);
                countsItem[i]++;
                if (group[i] != -1 && group[before] != group[i])
                    countsGroup[group[i]]++;
            }
        }
        Deque<Integer> Dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (group[i] == -1 && countsItem[i] == 0)
                Dq.offerLast(i);
        }
        for (int i = 0; i < m; i++) {
            if (countsGroup[i] == 0) {
                for (int item : groups[i]) {
                    if (countsItem[item] == 0)
                        Dq.offerLast(item);
                }
            }
        }
        int[] res = new int[n];
        int idx = 0;
        while (!Dq.isEmpty()) {
            int current = Dq.pollFirst();
            res[idx++] = current;
            for (int next : links[current]) {
                if (countsItem[next]-- == 1) {
                    if (group[current] == group[next]) {
                        Dq.offerFirst(next);
                    } else if (group[next] == -1) {
                        Dq.offerLast(next);
                    }
                }
                if (group[next] != -1 && countsGroup[group[next]]-- == 1) {
                    for (int item : groups[group[next]]) {
                        if (countsItem[item] == 0)
                            Dq.offerLast(item);
                    }
                }
            }
        }
        if (idx < n)
            return new int[0];
        return res;
    }
}
