/*
 * Problem: 277. Find the Celebrity
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-celebrity/
 * Language: java
 * Date: 2026-03-31
 */

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (knows(l, i))
                l = i;
        }
        for (int i = 0; i < l; i++) {
            if (knows(l, i) || !knows(i, l))
                return -1;
        }
        for (int i = l + 1; i < n; i++) {
            if (knows(l, i) || !knows(i, l))
                return -1;
        }
        return l;
    }
}
