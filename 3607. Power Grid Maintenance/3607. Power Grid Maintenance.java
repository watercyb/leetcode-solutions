/*
 * Problem: 3607. Power Grid Maintenance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/power-grid-maintenance/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] links = new int[c];
        int[] counts = new int[c];
        for (int i = 0; i < c; i++) {
            links[i] = i;
            counts[i] = 1;
        }
        int count = c;
        for (int[] connection : connections) {
            int a = find(links, connection[0] - 1);
            int b = find(links, connection[1] - 1);
            if (a != b) {
                links[b] = a;
                counts[a] += counts[b];
                count--;
            }
        }
        int[][] groups = new int[count][];
        int[] index = new int[count];
        int idx = 0;
        int[] toGroupIds = new int[c];
        Arrays.fill(toGroupIds, -1);
        for (int i = 0; i < links.length; i++) {
            if (i == find(links, i)) {
                toGroupIds[i] = idx;
                groups[idx] = new int[counts[i]];
                idx++;
            }
        }
        for (int i = 0; i < links.length; i++) {
            int a = find(links, i);
            groups[toGroupIds[a]][index[toGroupIds[a]]++] = i;
            toGroupIds[i] = toGroupIds[a];
        }
        for (int i = 0; i < groups.length; i++) {
            Arrays.sort(groups[i]);
        }
        boolean[] offlines = new boolean[c];
        count = 0;
        for (int[] query : queries) {
            count += query[0] & 1;
        }
        int[] res = new int[count];
        idx = 0;
        Arrays.fill(index, 0);
        for (int[] query : queries) {
            if (query[0] == 2) {
                offlines[query[1] - 1] = true;
            } else {
                if (!offlines[query[1] - 1]) {
                    res[idx++] = query[1];
                } else {
                    int groupId = toGroupIds[query[1] - 1];
                    int groupArrIdx = index[groupId];
                    while (groupArrIdx < groups[groupId].length && offlines[groups[groupId][groupArrIdx]]) {
                        groupArrIdx++;
                    }
                    if (groupArrIdx == groups[groupId].length) {
                        res[idx++] = -1;
                    } else {
                        res[idx++] = groups[groupId][groupArrIdx] + 1;
                    }
                    index[groupId] = groupArrIdx;
                }
            }
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
