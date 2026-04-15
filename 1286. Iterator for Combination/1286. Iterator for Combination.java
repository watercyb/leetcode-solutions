/*
 * Problem: 1286. Iterator for Combination
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/iterator-for-combination/
 * Language: java
 * Date: 2026-04-15
 */

class CombinationIterator {
    char[] chrs;
    int[] idx;

    public CombinationIterator(String characters, int combinationLength) {
        chrs = characters.toCharArray();
        idx = new int[combinationLength];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
    }

    public String next() {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < idx.length; i++) {
            SB.append(chrs[idx[i]]);
        }
        int i = idx.length - 1;
        while (i >= 0 && idx[i] == chrs.length - idx.length + i) {
            i--;
        }
        if (i == -1) {
            idx[0] = -1;
        } else {
            idx[i++]++;
            while (i < idx.length) {
                idx[i] = idx[i - 1] + 1;
                i++;
            }
        }
        return SB.toString();
    }

    public boolean hasNext() {
        return idx[0] >= 0;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters,
 * combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
