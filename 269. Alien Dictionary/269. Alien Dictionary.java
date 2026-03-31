/*
 * Problem: 269. Alien Dictionary
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/alien-dictionary/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public String alienOrder(String[] words) {
        List<List<Integer>> Li = new ArrayList<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < 26; i++) {
            Li.add(new ArrayList<>());
        }
        char[][] chrs = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            chrs[i] = words[i].toCharArray();
            for (int j = 0; j < chrs[i].length; j++) {
                seen[chrs[i][j] - 'a'] = true;
            }
        }
        int[] counts = new int[26];
        boolean[][] used = new boolean[26][26];
        for (int i = 0; i < chrs.length - 1; i++) {
            for (int k = 0; k < chrs[i].length; k++) {
                if (k == chrs[i + 1].length)
                    return "";
                int a = chrs[i][k] - 'a';
                int b = chrs[i + 1][k] - 'a';
                if (a != b) {
                    if (!used[b][a]) {
                        used[b][a] = true;
                        counts[b]++;
                        Li.get(a).add(b);
                    }
                    break;
                }
            }
        }
        Queue<Integer> Qu = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (seen[i]) {
                count++;
                if (counts[i] == 0)
                    Qu.add(i);
            }
        }
        char[] res = new char[count];
        int idx = 0;
        while (!Qu.isEmpty()) {
            int tmp = Qu.poll();
            res[idx++] = (char) (tmp + 'a');
            for (int next : Li.get(tmp)) {
                counts[next]--;
                if (counts[next] == 0)
                    Qu.add(next);
            }
        }
        if (idx < res.length)
            return "";
        return new String(res);
    }
}
