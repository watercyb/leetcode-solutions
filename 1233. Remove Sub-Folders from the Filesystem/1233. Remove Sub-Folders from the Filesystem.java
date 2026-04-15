/*
 * Problem: 1233. Remove Sub-Folders from the Filesystem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a, b) -> a.length() - b.length());
        TrieNode root = new TrieNode();
        List<String> res = new ArrayList<>();
        for (String str : folder) {
            if (insert(root, str))
                res.add(str);
        }
        return res;
    }

    public boolean insert(TrieNode root, String str) {
        char[] chrs = str.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] == '/' ? 26 : chrs[i] - 'a';
            if (root.next[idx] == null) {
                root.next[idx] = new TrieNode();
            } else if (root.next[idx].isFolder && chrs[i + 1] == '/') {
                return false;
            }
            root = root.next[idx];
        }
        root.isFolder = true;
        return true;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[27];
    boolean isFolder = false;
}
