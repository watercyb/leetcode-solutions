/*
 * Problem: 1825. Finding MK Average
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/finding-mk-average/
 * Language: java
 * Date: 2026-04-21
 */

class MKAverage {
    int[] counts = new int[100001];
    TreeSet<Integer> TS = new TreeSet<>();
    Deque<Integer> Dq = new ArrayDeque<>();
    int m;
    int k;
    int n = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        n = m - 2 * k;
    }

    public void addElement(int num) {
        if (m > 0) {
            m--;
        } else {
            counts[Dq.pollFirst()]--;
        }
        TS.add(num);
        counts[num]++;
        Dq.offerLast(num);
    }

    public int calculateMKAverage() {
        if (m > 0)
            return -1;
        long sum = 0;
        int prv = k;
        int count = n;
        for (int tmp : TS) {
            int v = counts[tmp];
            if (prv > 0) {
                if (v < prv) {
                    prv -= v;
                } else {
                    v -= prv;
                    prv = 0;
                    if (v < count) {
                        count -= v;
                        sum += (long) tmp * v;
                    } else {
                        sum += (long) tmp * count;
                        break;
                    }
                }
            } else {
                if (v < count) {
                    count -= v;
                    sum += (long) tmp * v;
                } else {
                    sum += (long) tmp * count;
                    break;
                }
            }
        }
        return (int) (sum / n);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
