/*
 * Problem: 3458. Select K Disjoint Special Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/select-k-disjoint-special-substrings/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public boolean maxSubstringLength(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] first = new int[26];
        Arrays.fill(first, chrs.length);
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (first[idx] == -1)
                first[idx] = i;
            last[idx] = i;
        }
        List<int[]> ranges = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1) {
                int l = first[i];
                int r = last[i];
                int idx = l + 1;
                while (idx <= r) {
                    int index = chrs[idx] - 'a';
                    if (first[index] < l)
                        break;
                    r = Math.max(last[index], r);
                    idx++;
                }
                if (idx <= r)
                    continue;
                ranges.add(new int[] { l, r });
            }
        }
        Collections.sort(ranges, (a, b) -> a[1] - b[1]);
        int count = 0;
        int prv = -1;
        for (int[] range : ranges) {
            if (range[0] > prv) {
                count++;
                prv = range[1];
            }
        }
        if (ranges.size() == 1 && ranges.getFirst()[0] == 0 && ranges.getFirst()[1] == chrs.length - 1 && k == 1)
            return false;
        return count >= k;
    }
}
