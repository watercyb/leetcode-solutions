/*
 * Problem: 2092. Find All People With Secret
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-all-people-with-secret/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        boolean[] knowns = new boolean[n];
        knowns[0] = true;
        knowns[firstPerson] = true;
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        int l = 0;
        while (l < meetings.length) {
            int r = l + 1;
            while (r < meetings.length && meetings[r][2] == meetings[l][2]) {
                r++;
            }
            if (r == l + 1) {
                if (knowns[meetings[l][0]]) {
                    knowns[meetings[l][1]] = true;
                } else if (knowns[meetings[l][1]]) {
                    knowns[meetings[l][0]] = true;
                }
            } else {
                chk(meetings, knowns, links, l, r);
            }
            l = r;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (knowns[i])
                res.add(i);
        }
        return res;
    }

    public void chk(int[][] meetings, boolean[] knowns, int[] links, int l, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = l; i < r; i++) {
            list.add(meetings[i][0]);
            list.add(meetings[i][1]);
            int a = find(links, meetings[i][0]);
            int b = find(links, meetings[i][1]);
            if (a != b) {
                if (knowns[a]) {
                    links[b] = a;
                } else {
                    links[a] = b;
                }
            }
        }
        for (int idx : list) {
            if (knowns[find(links, idx)])
                knowns[idx] = true;
        }
        for (int idx : list) {
            links[idx] = idx;
        }
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
