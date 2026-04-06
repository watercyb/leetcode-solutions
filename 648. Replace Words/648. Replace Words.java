/*
 * Problem: 648. Replace Words
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/replace-words/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieTree trietree = new TrieTree();

        for (String str : dictionary) {
            trietree.Add(str);
        }

        String[] arrStr = sentence.split(" ");

        StringBuilder str =new StringBuilder();
        for (int i = 0; i < arrStr.length; i++) {
            if (i != 0)
                str.append(" ");
            str.append(trietree.getVal(arrStr[i]));
        }

        return str.toString();
    }

}

class TrieTree {
     public TrieNode root;

    class TrieNode {
        public char val;
        public boolean isWord=false;
        private TrieNode[] Children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(char val) {
            this.val = val;
        }
    }

    public TrieTree() {
        root = new TrieNode();
    }

    public String getVal(String str) {
        TrieNode pin = root;
        char[] chrs = str.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            int n=chrs[i]-'a';
            if (pin.Children[n] == null)
                return str;
            if (pin.Children[n].isWord)
                return str.substring(0, i + 1);
            pin=pin.Children[n];
        }
        return str;
    }

    public void Add(String str) {
        TrieNode pin = root;
        for (char chr : str.toCharArray()) {
            int n = chr - 'a';
            if (pin.Children[n] == null) {
                pin.Children[n] = new TrieNode(chr);
            }
            pin=pin.Children[n];
        }
        pin.isWord=true;
    }

}
