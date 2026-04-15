/*
 * Problem: 1244. Design A Leaderboard
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-a-leaderboard/
 * Language: java
 * Date: 2026-04-15
 */

class Leaderboard {
    int[] counts = new int[100001];
    int[] scores = new int[100001];
    int max = -1;

    public Leaderboard() {

    }

    public void addScore(int playerId, int score) {
        counts[scores[playerId]]--;
        scores[playerId] += score;
        counts[scores[playerId]]++;
        max = Math.max(scores[playerId], max);
    }

    public int top(int K) {
        int res = 0;
        boolean empty = true;
        for (int i = max; i > 0 && K > 0; i--) {
            if (counts[i] == 0) {
                if (empty)
                    max--;
                continue;
            }
            empty = false;
            if (K > counts[i]) {
                K -= counts[i];
                res += i * counts[i];
            } else {
                res += i * K;
                K = 0;
            }
        }
        return res;
    }

    public void reset(int playerId) {
        addScore(playerId, -scores[playerId]);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
