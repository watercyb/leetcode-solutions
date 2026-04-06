/*
 * Problem: 676. Implement Magic Dictionary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/implement-magic-dictionary/
 * Language: java
 * Date: 2026-04-06
 */

class MagicDictionary {
    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary) {
            char[] chrs = str.toCharArray();
            Trie node = root;
            for (int i = 0; i < chrs.length; i++) {
                int idx = chrs[i] - 'a';
                if (node.next[idx] == null)
                    node.next[idx] = new Trie();
                node = node.next[idx];
            }
            node.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord.toCharArray(), false, 0);
    }

    public boolean dfs(Trie node, char[] chrs, boolean changed, int i) {
        if (i == chrs.length)
            return changed && node.isWord;
        int idx = chrs[i] - 'a';
        if (changed) {
            if (node.next[idx] != null) {
                if (dfs(node.next[idx], chrs, changed, i + 1))
                    return true;
            }
        } else {
            for (int j = 0; j < 26; j++) {
                if (node.next[j] != null && dfs(node.next[j], chrs, j != idx, i + 1))
                    return true;
            }
        }
        return false;
    }
}

class Trie {
    boolean isWord = false;
    Trie[] next = new Trie[26];
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
