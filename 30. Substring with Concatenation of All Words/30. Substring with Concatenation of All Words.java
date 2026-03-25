/*
 * Problem: 30. Substring with Concatenation of All Words
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n1 = words[0].length();
        int n2 = n1 * words.length;
        List<Integer> res = new ArrayList<>();
        if (s.length() < n1 * words.length)
            return res;
        HashMap<Long, Integer> h = new HashMap<>();
        List<Integer> counts = new ArrayList<>();
        for (String str : words) {
            long tmp = 0;
            for (char chr : str.toCharArray()) {
                tmp *= 26;
                tmp += chr - 'a';
            }
            if (h.containsKey(tmp)) {
                int idx = h.get(tmp);
                counts.set(idx, counts.get(idx) + 1);
            } else {
                h.put(tmp, h.size());
                counts.add(1);
            }
        }
        int[] arr = new int[counts.size()];
        for (int i = 0; i < counts.size(); i++) {
            arr[i] = counts.get(i);
        }
        char[] chrs = s.toCharArray();
        for (int i = 0; i < n1; i++) {
            if (i + n2 > chrs.length)
                break;
            int[] arrTmp = arr.clone();
            int diff = words.length;
            Deque<Long> Dq = new ArrayDeque<>();
            for (int j = i; j < n2 + i; j += n1) {
                long tmp = 0;
                for (int k = j; k < n1 + j; k++) {
                    tmp *= 26;
                    tmp += chrs[k] - 'a';
                }
                Dq.offerLast(tmp);
                if (h.containsKey(tmp)) {
                    int idx = h.get(tmp);
                    arrTmp[idx]--;
                    if (arrTmp[idx] >= 0) {
                        diff--;
                    } else {
                        diff++;
                    }
                }
            }
            if (diff == 0)
                res.add(i);
            for (int j = i + n2; j <= chrs.length - n1; j += n1) {
                long last = Dq.pollFirst();
                if (h.containsKey(last)) {
                    int idx = h.get(last);
                    arrTmp[idx]++;
                    if (arrTmp[idx] >= 1) {
                        diff++;
                    } else {
                        diff--;
                    }
                }
                long tmp = 0;
                for (int k = j; k < n1 + j; k++) {
                    tmp *= 26;
                    tmp += chrs[k] - 'a';
                }
                Dq.offerLast(tmp);
                if (h.containsKey(tmp)) {
                    int idx = h.get(tmp);
                    arrTmp[idx]--;
                    if (arrTmp[idx] >= 0) {
                        diff--;
                    } else {
                        diff++;
                    }
                }
                if (diff == 0)
                    res.add(j - (n2 - n1));
            }
        }
        return res;
    }
}
