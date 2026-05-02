/*
 * Problem: 2901. Longest Unequal Adjacent Groups Subsequence II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        HashMap<Long, List<Integer>> HM = new HashMap<>(words.length, 0.99f);
        long[] masks = new long[10];
        masks[0] = 1;
        for (int i = 1; i < 10; i++) {
            masks[i] = masks[i - 1] * 26;
        }
        int[] links = new int[words.length];
        int[] lens = new int[words.length];
        Arrays.fill(lens, 1);
        int max = 1;
        int idx = 0;
        for (int i = 0; i < words.length; i++) {
            links[i] = i;
            char[] chrs = words[i].toCharArray();
            long h = getH(chrs);
            List<Integer> list;
            if (!HM.containsKey(h)) {
                list = new ArrayList<>();
                HM.put(h, list);
            } else {
                list = HM.get(h);
            }
            int len = 1;
            int prvIdx = i;
            for (int j = 0; j < chrs.length; j++) {
                for (int k = 0; k < 26; k++) {
                    if (k == chrs[j] - 'a')
                        continue;
                    long hNext = h + (k - chrs[j] + 'a') * masks[j];
                    if (HM.containsKey(hNext)) {
                        for (int prv : HM.get(hNext)) {
                            if (groups[prv] == groups[i] || words[prv].length() != words[i].length())
                                continue;
                            int currentLen = lens[prv] + 1;
                            if (currentLen > len) {
                                len = currentLen;
                                prvIdx = prv;
                            }
                        }
                    }
                }
            }
            list.add(i);
            links[i] = prvIdx;
            lens[i] = len;
            if (len > max) {
                max = len;
                idx = i;
            }
        }
        List<String> res = new ArrayList<>();
        while (true) {
            res.addFirst(words[idx]);
            if (idx == links[idx])
                break;
            idx = links[idx];
        }
        return res;
    }

    public long getH(char[] chrs) {
        long res = 0;
        for (int i = chrs.length - 1; i >= 0; i--) {
            res = res * 26 + chrs[i] - 'a';
        }
        return res;
    }
}
