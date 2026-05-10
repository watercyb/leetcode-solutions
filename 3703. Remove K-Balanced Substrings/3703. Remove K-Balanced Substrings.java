/*
 * Problem: 3703. Remove K-Balanced Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-k-balanced-substrings/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String removeSubstring(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] arr = new int[chrs.length];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            char chr = chrs[i];
            int j = i + 1;
            while (j < chrs.length && chrs[j] == chr) {
                j++;
            }
            int count = j - i;
            if (chr == ')') {
                arr[idx++] = -count;
            } else {
                arr[idx++] = count;
            }
            i = j - 1;
        }
        int lim = idx;
        idx = 0;
        for (int i = 0; i < lim; i++) {
            if (idx == 0) {
                arr[idx++] = arr[i];
            } else if ((long) arr[idx - 1] * arr[i] > 0) {
                arr[i--] += arr[--idx];
            } else if (arr[idx - 1] < 0 || arr[i] > -k || arr[idx - 1] < k) {
                arr[idx++] = arr[i];
            } else {
                int n = Math.min(arr[idx - 1] / k, -arr[i] / k) * k;
                arr[idx - 1] -= n;
                if (arr[idx - 1] == 0)
                    idx--;
                arr[i] += n;
                if (arr[i] != 0)
                    i--;
            }
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    SB.append('(');
                }
            } else {
                for (int j = 0; j < -arr[i]; j++) {
                    SB.append(')');
                }
            }
        }
        return SB.toString();
    }
}
