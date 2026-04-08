/*
 * Problem: 792. Number of Matching Subsequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-matching-subsequences/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Node> HM = new HashMap<>();
        List<Node>[] lists = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        for (String word : words) {
            int tmp = word.charAt(0) - 'a';
            if (!HM.containsKey(word)) {
                Node node = new Node(word);
                lists[tmp].add(node);
                HM.put(word, node);
            } else {
                HM.get(word).count++;
            }
        }
        int res = 0;
        for (char chr : s.toCharArray()) {
            List<Node> tmp = lists[chr - 'a'];
            List<Node> next = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                Node node = tmp.get(i);
                if (node.idx == node.chrs.length - 1) {
                    res += node.count;
                } else {
                    node.idx++;
                    char chrNext = node.chrs[node.idx];
                    if (chrNext == chr) {
                        next.add(node);
                    } else {
                        lists[chrNext - 'a'].add(node);
                    }
                }
            }
            lists[chr - 'a'] = next;
        }
        return res;
    }
}

class Node {
    char[] chrs;
    int idx = 0;
    int count = 1;

    public Node(String str) {
        chrs = str.toCharArray();
    }
}
