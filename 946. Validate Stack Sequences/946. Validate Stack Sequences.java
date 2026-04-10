/*
 * Problem: 946. Validate Stack Sequences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/validate-stack-sequences/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushed[idx] = pushed[i];
            while (idx >= 0 && pushed[idx] == popped[j]) {
                idx--;
                j++;
            }
            idx++;
        }
        return j == popped.length;
    }
}
