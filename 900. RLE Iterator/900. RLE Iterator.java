/*
 * Problem: 900. RLE Iterator
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/rle-iterator/
 * Language: java
 * Date: 2026-04-09
 */

class RLEIterator {
    int[] encoding;
    int idx = 0;

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {
        while (n > 0) {
            while (idx < encoding.length && encoding[idx] == 0) {
                idx += 2;
            }
            if (idx >= encoding.length)
                return -1;
            if (encoding[idx] < n) {
                n -= encoding[idx];
                idx += 2;
            } else {
                encoding[idx] -= n;
                return encoding[idx + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
