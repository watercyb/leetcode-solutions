/*
 * Problem: 1622. Fancy Sequence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/fancy-sequence/
 * Language: java
 * Date: 2026-04-19
 */

class Fancy {
    int mod = 1_000_000_007;
    long sum = 0;
    long mult = 1;
    long rev = 1;
    List<Long> list = new ArrayList<>();
    int[] revs = new int[101];

    public Fancy() {

    }

    public void append(int val) {
        list.add((long) (val - sum) * rev % mod);
    }

    public void addAll(int inc) {
        sum += inc;
    }

    public void multAll(int m) {
        sum = sum * m % mod;
        mult = mult * m % mod;
        rev = rev * rev(m) % mod;
    }

    public int getIndex(int idx) {
        if (idx < list.size())
            return (int) ((list.get(idx) * mult % mod + sum + mod) % mod);
        return -1;
    }

    public int rev(int a) {
        if (revs[a] != 0)
            return revs[a];
        return revs[a] = (int) getRev(a);
    }

    public long getRev(long a) {
        if (a == 1)
            return 1;
        return mod - (long) mod / a * getRev(mod % a) % mod;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
