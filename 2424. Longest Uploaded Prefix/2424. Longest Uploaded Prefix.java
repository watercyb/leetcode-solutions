/*
 * Problem: 2424. Longest Uploaded Prefix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-uploaded-prefix/
 * Language: java
 * Date: 2026-04-27
 */

class LUPrefix {
    boolean[] has;
    int idx = 0;

    public LUPrefix(int n) {
        has = new boolean[n + 1];
    }

    public void upload(int video) {
        has[video - 1] = true;
        while (has[idx]) {
            idx++;
        }
    }

    public int longest() {
        return idx;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
