/*
 * Problem: 3435. Frequencies of Shortest Supersequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/frequencies-of-shortest-supersequences/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public List<List<Integer>> supersequences(String[] words) {
        List<Integer>[] lists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] counts = new int[26];
        int[] needs = new int[26];
        int[] sides = new int[26];
        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            if (a == b) {
                needs[a] = 2;
                counts[a]++;
            } else {
                lists[a].add(b);
                counts[a]++;
                counts[b]++;
                sides[a] |= 1;
                sides[b] |= 2;
            }
        }
        int[][] links = new int[26][];
        for (int i = 0; i < 26; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < lists[i].size(); j++) {
                links[i][j] = lists[i].get(j);
            }
            if (counts[i] == 0 || needs[i] == 2)
                continue;
            if (counts[i] == 1 || sides[i] != 3) {
                needs[i] = 1;
            } else {
                needs[i] = -1;
            }
        }
        dfs(links, 0, needs, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int[] arr : resLists) {
            List<Integer> list = new ArrayList<>();
            for (int n : arr) {
                list.add(n);
            }
            res.add(list);
        }
        return res;
    }

    int min = Integer.MAX_VALUE;
    List<int[]> resLists = new ArrayList<>();

    public void dfs(int[][] links, int i, int[] needs, int n) {
        if (n > min)
            return;
        if (i == 26) {
            if (!chk(links, needs))
                return;
            if (n < min) {
                min = n;
                resLists = new ArrayList<>();
                resLists.add(needs.clone());
            } else if (n == min) {
                resLists.add(needs.clone());
            }
            return;
        }
        if (needs[i] >= 0) {
            dfs(links, i + 1, needs, n + needs[i]);
        } else {
            needs[i] = 1;
            dfs(links, i + 1, needs, n + 1);
            needs[i] = 2;
            dfs(links, i + 1, needs, n + 2);
            needs[i] = -1;
        }
    }

    public boolean chk(int[][] links, int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 1 && !dfs(links, arr, new boolean[26], i))
                return false;
        }
        return true;
    }

    public boolean dfs(int[][] links, int[] arr, boolean[] seens, int i) {
        seens[i] = true;
        for (int next : links[i]) {
            if (arr[next] == 1 && (seens[next] || !dfs(links, arr, seens, next)))
                return false;
        }
        seens[i] = false;
        return true;
    }
}
