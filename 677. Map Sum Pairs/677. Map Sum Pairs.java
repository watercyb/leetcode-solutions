/*
 * Problem: 677. Map Sum Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/map-sum-pairs/
 * Language: java
 * Date: 2026-04-06
 */

class MapSum {
    Trie root;

    public MapSum() {
        root = new Trie();
    }

    public void insert(String key, int val) {
        char[] chrs = key.toCharArray();
        dfs(root, chrs, val, 0);
    }

    public int dfs(Trie node, char[] chrs, int val, int i) {
        if (i == chrs.length) {
            int diff = val;
            if (node.isWord) {
                diff -= node.val;
            } else {
                node.isWord = true;
            }
            node.val = val;
            node.sum += diff;
            return diff;
        }
        int next = chrs[i] - 'a';
        if (node.next[next] == null) {
            node.next[next] = new Trie();
        }
        int chg = dfs(node.next[next], chrs, val, i + 1);
        node.sum += chg;
        return chg;
    }

    public int sum(String prefix) {
        char[] chrs = prefix.toCharArray();
        Trie node = root;
        for (int i = 0; i < chrs.length; i++) {
            if (node.next[chrs[i] - 'a'] == null) {
                return 0;
            }
            node = node.next[chrs[i] - 'a'];
        }
        return node.sum;
    }
}

class Trie {
    boolean isWord = false;
    int val = 0;
    int sum = 0;
    Trie[] next = new Trie[26];
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
