/*
 * Problem: 527. Word Abbreviation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/word-abbreviation/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        HashMap<String, List<Node>> HM = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int l = word.length();
            if (l > 3) {
                String str = new StringBuilder().append(word.charAt(0)).append((l - 2)).append(word.charAt(l - 1))
                        .toString();
                if (HM.containsKey(str)) {
                    HM.get(str).add(new Node(word, i));
                } else {
                    List<Node> list = new ArrayList<>();
                    list.add(new Node(word, i));
                    HM.put(str, list);
                }
            }
        }
        for (Map.Entry<String, List<Node>> entry : HM.entrySet()) {
            List<Node> list = entry.getValue();
            if (list.size() == 1) {
                Node node = list.getFirst();
                words.set(node.idx, entry.getKey());
            } else {
                dfs(list, words, list.getFirst().str.length(), 1);
            }
        }
        return words;
    }

    public void dfs(List<Node> list, List<String> words, int length, int n) {
        if (n == length - 3) {
            for (Node node : list) {
                words.set(node.idx, node.str);
            }
        } else {
            HashMap<String, List<Node>> HM = new HashMap<>();
            for (Node node : list) {
                String str = new StringBuilder().append(node.str.substring(0, n + 1)).append((length - n - 2))
                        .append(node.str.charAt(length - 1))
                        .toString();
                if (HM.containsKey(str)) {
                    HM.get(str).add(node);
                } else {
                    List<Node> listTemp = new ArrayList<>();
                    listTemp.add(node);
                    HM.put(str, listTemp);
                }
            }
            for (Map.Entry<String, List<Node>> entry : HM.entrySet()) {
                List<Node> listTemp = entry.getValue();
                if (listTemp.size() == 1) {
                    Node node = listTemp.getFirst();
                    words.set(node.idx, entry.getKey());
                } else {
                    dfs(listTemp, words, length, n + 1);
                }
            }
        }
    }
}

class Node {
    String str;
    int idx;

    public Node(String str, int idx) {
        this.str = str;
        this.idx = idx;
    }
}
