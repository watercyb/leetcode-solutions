/*
 * Problem: 519. Random Flip Matrix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/random-flip-matrix/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    Random random = new Random();
    int size;
    int m;
    int n;
    HashMap<Integer, Integer> HM = new HashMap<>();

    public Solution(int m, int n) {
        size = m * n;
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int r = random.nextInt(size--);
        int h = HM.getOrDefault(r, r);
        if (r != size)
            HM.put(r, HM.getOrDefault(size, size));
        return new int[] { h / n, h % n };
    }

    public void reset() {
        HM.clear();
        size = m * n;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
