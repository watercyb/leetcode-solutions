/*
 * Problem: 3245. Alternating Groups III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/alternating-groups-iii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public List<Integer> numberOfAlternatingGroups(int[] colors, int[][] queries) {
        int n = colors.length;
        int len = 0;
        int prv = colors[0];
        BIT bit = new BIT(n * 2);
        TreeSet<Integer> TS = new TreeSet<>();
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            if (colors[i] != prv) {
                len++;
                prv = colors[i];
            } else {
                TS.add(i);
                if (len > 0) {
                    bit.insert(len, 1);
                }
                len = 1;
            }
            arr[i] = colors[i];
        }
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (colors[i] != prv) {
                len++;
                prv = colors[i];
            } else {
                TS.add(i + n);
                if (len > 0 && first) {
                    first = false;
                    bit.insert(len, 1);
                }
                len = 1;
            }
            arr[i + n] = colors[i];
        }
        TS.add(n * 2);
        if (first)
            bit.insert(len, 1);
        List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                res.add(bit.get(query[1] - 1)
                        - Math.max(TS.higher(n - 1) - n - query[1] + 1, 0));
            } else {
                int idx = query[1];
                int num = query[2];
                if (arr[idx] == num)
                    continue;
                arr[idx] = num;
                arr[idx + n] = num;
                int l = TS.floor(idx);
                int r = TS.higher(idx);
                int prv1 = l;
                int prv2 = l;
                if (l > 0 && l == idx)
                    prv1 = prv2 = TS.floor(l - 1);
                if (l == idx) {
                    if (idx != 0)
                        TS.remove(idx);
                    if (prv1 < n)
                        bit.insert(idx - prv1, -1);
                    prv1 = idx;
                } else {
                    TS.add(idx);
                    if (prv2 < n)
                        bit.insert(idx - prv2, 1);
                    prv2 = idx;
                }
                if (r == idx + 1) {
                    TS.remove(idx + 1);
                    if (prv1 < n)
                        bit.insert(idx + 1 - prv1, -1);
                    prv1 = idx + 1;
                } else {
                    TS.add(idx + 1);
                    if (prv2 < n)
                        bit.insert(idx + 1 - prv2, 1);
                    prv2 = idx + 1;
                }
                int rr = TS.higher(idx + 1);
                if (prv1 < n)
                    bit.insert(rr - prv1, -1);
                if (prv2 < n)
                    bit.insert(rr - prv2, 1);

                idx += n;
                l = TS.floor(idx);
                r += n;
                prv1 = l;
                prv2 = l;
                if (l > 0 && l == idx)
                    prv1 = prv2 = TS.floor(l - 1);
                if (l == idx) {
                    if (idx != 0)
                        TS.remove(idx);
                    if (prv1 < n)
                        bit.insert(idx - prv1, -1);
                    prv1 = idx;
                } else {
                    TS.add(idx);
                    if (prv2 < n)
                        bit.insert(idx - prv2, 1);
                    prv2 = idx;
                }
                if (r == idx + 1) {
                    if (idx + 1 < n * 2)
                        TS.remove(idx + 1);
                    if (prv1 < n)
                        bit.insert(idx + 1 - prv1, -1);
                    prv1 = idx + 1;
                } else {
                    TS.add(idx + 1);
                    if (prv2 < n)
                        bit.insert(idx + 1 - prv2, 1);
                    prv2 = idx + 1;
                }
                rr = idx + 1 < n * 2 ? TS.higher(idx + 1) : idx + 1;
                if (prv1 < n)
                    bit.insert(rr - prv1, -1);
                if (prv2 < n)
                    bit.insert(rr - prv2, 1);
            }
        }
        return res;
    }
}

class BIT {
    int[] bit1;
    int[] bit2;
    int count = 0;
    int sum = 0;

    public BIT(int n) {
        bit1 = new int[n + 2];
        bit2 = new int[n + 2];
    }

    public void insert(int i, int a) {
        if (i == 0)
            return;
        int len = a * i;
        count += a;
        sum += len;
        i++;
        while (i < bit1.length) {
            bit1[i] += a;
            bit2[i] += len;
            i += i & -i;
        }
    }

    public int get(int i) {
        int len = i;
        i++;
        int a = 0;
        int b = 0;
        while (i > 0) {
            a += bit1[i];
            b += bit2[i];
            i -= i & -i;
        }
        return sum - b - (count - a) * len;
    }
}

