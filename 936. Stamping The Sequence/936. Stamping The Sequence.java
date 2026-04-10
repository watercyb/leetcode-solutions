/*
 * Problem: 936. Stamping The Sequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stamping-the-sequence/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] chrS = stamp.toCharArray();
        char[] chrT = target.toCharArray();
        if (chrS[0] != chrT[0] || chrS[chrS.length - 1] != chrT[chrT.length - 1])
            return new int[0];
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> last = new LinkedList<>();
        for (int i = chrT.length - chrS.length; i >= 0; i--) {
            if (chrT[i] == chrS[0])
                first.offer(i);
        }
        for (int i = chrS.length - 1; i < chrT.length; i++) {
            if (chrT[i] == chrS[chrS.length - 1])
                last.offer(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int idx : first) {
            if (chrT[idx] != chrS[0])
                continue;
            int i = 0;
            while (i < chrS.length) {
                if (chrT[idx + i] != chrS[i] && chrT[idx + i] != '@')
                    break;
                i++;
            }
            if (i == chrS.length) {
                list.add(idx);
                for (int j = idx; j < idx + chrS.length; j++) {
                    chrT[j] = '@';
                }
            }
        }
        for (int idx : last) {
            if (chrT[idx] != chrS[chrS.length - 1])
                continue;
            int i = 0;
            while (i < chrS.length) {
                if (chrT[idx - i] != chrS[chrS.length - 1 - i] && chrT[idx - i] != '@')
                    break;
                i++;
            }
            if (i == chrS.length) {
                list.add(idx - chrS.length + 1);
                for (int j = idx; j >= idx - chrS.length + 1; j--) {
                    chrT[j] = '@';
                }
            }
        }
        if (chrT[0] != '@') {
            int i = 0;
            while (i < chrS.length) {
                if (chrT[i] != chrS[i] && chrT[i] != '@')
                    return new int[0];
                i++;
            }
            if (i == chrS.length)
                list.add(0);
        }
        if (chrT[chrT.length - 1] != '@') {
            int i = 1;
            while (i <= chrS.length) {
                if (chrT[chrT.length - i] != chrS[chrS.length - 1 - i] && chrT[chrT.length - i] != '@')
                    return new int[0];
                i++;
            }
            if (i == chrS.length + 1)
                list.add(chrT.length - chrS.length);
        }
        StringBuilder SB = new StringBuilder();
        for (int i = chrS.length; i <= chrT.length - chrS.length; i++) {
            if (chrT[i] != '@') {
                SB.append(chrT[i]);
            } else if (SB.length() > 0) {
                int idx = stamp.indexOf(SB.toString());
                if (idx < 0)
                    return new int[0];
                list.add(i - SB.length() - idx);
                SB.setLength(0);
            }
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[idx++] = list.get(i);
        }
        return res;
    }
}
