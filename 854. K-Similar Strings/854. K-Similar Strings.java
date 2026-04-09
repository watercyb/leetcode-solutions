/*
 * Problem: 854. K-Similar Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/k-similar-strings/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int kSimilarity(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        int count = chk(chrs1, chrs2);
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < chrs1.length; i++) {
            if (chrs1[i] != chrs2[i]) {
                list1.add(chrs1[i]);
                list2.add(chrs2[i]);
            }
        }
        if (list1.isEmpty())
            return count;
        chrs1 = new char[list1.size()];
        chrs2 = new char[list2.size()];
        for (int i = 0; i < chrs1.length; i++) {
            chrs1[i] = list1.get(i);
            chrs2[i] = list2.get(i);
        }
        Node node = new Node(chrs1, 0);
        Deque<Node> Dq = new ArrayDeque<>();
        Dq.offerLast(node);
        int stp = 1;
        HashSet<Long> HS = new HashSet<>();
        while (!Dq.isEmpty()) {
            int lim = Dq.size();
            for (int i = 0; i < lim; i++) {
                Node current = Dq.pollFirst();
                char[] chrs = current.chrs;
                int idx = current.i;
                for (int j = idx + 1; j < chrs.length; j++) {
                    if (chrs[j] == chrs2[idx]) {
                        swap(chrs, idx, j);
                        int k = idx + 1;
                        while (k < chrs.length && chrs[k] == chrs2[k]) {
                            k++;
                        }
                        if (k == chrs.length)
                            return stp + count;
                        node = new Node(chrs, k);
                        if (HS.add(node.h))
                            Dq.offerLast(node);
                        swap(chrs, idx, j);
                    }
                }
            }
            stp++;
        }
        return -1;
    }

    public int chk(char[] chrs1, char[] chrs2) {
        int res = 0;
        for (int i = 0; i < chrs1.length; i++) {
            if (chrs1[i] != chrs2[i]) {
                int j = i + 1;
                while (j < chrs1.length && (chrs1[j] != chrs2[i] || chrs2[j] != chrs1[i])) {
                    j++;
                }
                if (j < chrs1.length) {
                    swap(chrs1, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void swap(char[] chrs, int i, int j) {
        char temp = chrs[i];
        chrs[i] = chrs[j];
        chrs[j] = temp;
    }
}

class Node {
    char[] chrs;
    int i;
    long h;

    public Node(char[] chrs, int i) {
        this.chrs = chrs.clone();
        this.i = i;
        h = getH();
    }

    public long getH() {
        long res = 0;
        for (char chr : chrs) {
            res = res * 6 + chr - 'a';
        }
        return res;
    }
}
