/*
 * Problem: 642. Design Search Autocomplete System
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-search-autocomplete-system/
 * Language: java
 * Date: 2026-04-06
 */

class AutocompleteSystem {
    HashMap<String, Integer> HM = new HashMap<>();
    TrieTree head = new TrieTree();
    TrieTree node = head;
    StringBuilder SB = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            HM.put(sentences[i], times[i]);
        }
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            String sentence = entry.getKey();
            int count = entry.getValue();
            TrieTree node = head;
            for (char chr : sentence.toCharArray()) {
                if (chr == ' ') {
                    chr = 26;
                } else {
                    chr -= 'a';
                }
                if (node.next[chr] == null)
                    node.next[chr] = new TrieTree();
                node = node.next[chr];
                int j = 0;
                while (j < node.strs.size() && (count < node.counts.get(j)
                        || (count == node.counts.get(j) && sentence.compareTo(node.strs.get(j)) > 0))) {
                    j++;
                }
                node.strs.add(j, sentence);
                node.counts.add(j, count);
                if (node.strs.size() > 3) {
                    node.strs.remove(3);
                    node.counts.remove(3);
                }
            }
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            update(SB);
            node = head;
            SB.setLength(0);
            return new ArrayList<>();
        } else {
            SB.append(c);
            if (c == ' ') {
                c = 26;
            } else {
                c -= 'a';
            }
            if (node.next[c] == null)
                node.next[c] = new TrieTree();
            node = node.next[c];
            return new ArrayList<>(node.strs);
        }
    }

    public void update(StringBuilder SB) {
        String str = SB.toString();
        int count = HM.getOrDefault(str, 0) + 1;
        HM.put(str, count);
        TrieTree node = head;
        for (int i = 0; i < SB.length(); i++) {
            char chr = SB.charAt(i);
            if (chr == ' ') {
                chr = 26;
            } else {
                chr -= 'a';
            }
            node = node.next[chr];
            int j = 0;
            while (j < node.strs.size() && (count < node.counts.get(j)
                    || (count == node.counts.get(j) && str.compareTo(node.strs.get(j)) > 0))) {
                j++;
            }
            node.strs.add(j, str);
            node.counts.add(j, count);
            j++;
            while (j < node.strs.size()) {
                if (node.strs.get(j).equals(str)) {
                    node.strs.remove(j);
                    node.counts.remove(j);
                    break;
                }
                j++;
            }
            if (node.strs.size() > 3) {
                node.strs.remove(3);
                node.counts.remove(3);
            }
        }
    }
}

class TrieTree {
    TrieTree[] next = new TrieTree[27];
    List<String> strs = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();

    public TrieTree() {

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
