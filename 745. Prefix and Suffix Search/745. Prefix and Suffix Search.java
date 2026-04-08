/*
 * Problem: 745. Prefix and Suffix Search
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/prefix-and-suffix-search/
 * Language: java
 * Date: 2026-04-08
 */

class WordFilter {
    TrieNode left = new TrieNode();
    TrieNode right = new TrieNode();
    HashSet<String> HS = new HashSet<>();
    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
        for (int i = words.length - 1; i >= 0; i--) {
            insert(words[i].toCharArray(), i);
        }
    }

    public void insert(char[] chrs, int i) {
        if (!HS.add(words[i]))
            return;
        TrieNode node = left;
        for (int j = 0; j < chrs.length; j++) {
            int idx = chrs[j] - 'a';
            if (node.next[idx] == null)
                node.next[idx] = new TrieNode();
            node = node.next[idx];
            node.list.add(i);
        }
        node = right;
        for (int j = chrs.length - 1; j >= 0; j--) {
            int idx = chrs[j] - 'a';
            if (node.next[idx] == null)
                node.next[idx] = new TrieNode();
            node = node.next[idx];
            node.list.add(i);
        }
    }

    public int f(String pref, String suff) {
        TrieNode node = left;
        for (int i = 0; i < pref.length(); i++) {
            node = node.next[pref.charAt(i) - 'a'];
            if (node == null)
                return -1;
        }
        List<Integer> list = node.list;
        node = right;
        for (int i = suff.length() - 1; i >= 0; i--) {
            node = node.next[suff.charAt(i) - 'a'];
            if (node == null)
                return -1;
        }
        int i = 0;
        int j = 0;
        while (i < list.size() && j < node.list.size()) {
            int a = list.get(i);
            int b = node.list.get(j);
            if (a > b) {
                i++;
            } else if (a < b) {
                j++;
            } else {
                return a;
            }
        }
        return -1;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    List<Integer> list = new ArrayList<>();
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
