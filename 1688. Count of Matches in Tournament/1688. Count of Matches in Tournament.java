/*
 * Problem: 1688. Count of Matches in Tournament
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-of-matches-in-tournament/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int numberOfMatches(int n) {
        int re=0;
        while (n>1) {
            int tmp=n%2;
            n/=2;
            re+=n;
            n+=tmp;
        }
        return re;

    }
}
