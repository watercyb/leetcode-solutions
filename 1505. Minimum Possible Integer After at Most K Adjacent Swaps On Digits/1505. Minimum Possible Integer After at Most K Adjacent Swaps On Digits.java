/*
 * Problem: 1505. Minimum Possible Integer After at Most K Adjacent Swaps On Digits
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public String minInteger(String num, int k) {
        char[] chrs = num.toCharArray();
        int size = (int) Math.pow(2, Math.ceil(Math.log(chrs.length) / Math.log(2)));
        int[] segment = new int[2 * size - 1];
        Arrays.fill(segment, Integer.MAX_VALUE);
        int idx = size - 1;
        List<Integer>[] lists = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < chrs.length; i++) {
            int digit = chrs[i] - '0';
            segment[idx++] = digit;
            lists[digit].add(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            segment[i] = Math.min(segment[2 * i + 1], segment[2 * i + 2]);
        }
        int[] BIT = new int[chrs.length + 2];
        StringBuilder SB = new StringBuilder();
        while (k > 0) {
            int offset = 0;
            while (true) {
                if (k + offset >= chrs.length)
                    break;
                int offsetNext = getOffset(BIT, k + offset);
                if (offsetNext == offset)
                    break;
                offset = offsetNext;
            }
            int kk = Math.min(k + offset, chrs.length - 1);
            int min = getMin(segment, 0, 0, kk, 0, size - 1);
            if (min == Integer.MAX_VALUE)
                break;
            int minIdx = lists[min].getFirst();
            lists[min].removeFirst();
            SB.append(chrs[minIdx]);
            chrs[minIdx] = '#';
            remove(segment, minIdx + size - 1);
            int diff = getOffset(BIT, minIdx);
            insert(BIT, minIdx);
            minIdx -= diff;
            k -= minIdx;
        }
        for (char chr : chrs) {
            if (chr != '#')
                SB.append(chr);
        }
        return SB.toString();
    }

    public void insert(int[] BIT, int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int getOffset(int[] BIT, int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }

    public void remove(int[] segment, int i) {
        segment[i] = Integer.MAX_VALUE;
        while (true) {
            i = (i - 1) / 2;
            segment[i] = Math.min(segment[2 * i + 1], segment[2 * i + 2]);
            if (i == 0)
                return;
        }
    }

    public int getMin(int[] segment, int i, int l, int r, int left, int right) {
        if (l > right || r < left)
            return Integer.MAX_VALUE;
        if (l <= left && r >= right)
            return segment[i];
        int mid = (left + right) >>> 1;
        return Math.min(getMin(segment, 2 * i + 1, l, r, left, mid), getMin(segment, 2 * i + 2, l, r, mid + 1, right));
    }
}
