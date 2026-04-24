/*
 * Problem: 2166. Design Bitset
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-bitset/
 * Language: java
 * Date: 2026-04-24
 */

class Bitset {
    char[] a;
    char[] b;
    int count = 0;

    public Bitset(int size) {
        a = new char[size];
        b = new char[size];
        Arrays.fill(a, '0');
        Arrays.fill(b, '1');
    }

    public void fix(int idx) {
        if (a[idx] != '1') {
            a[idx] = '1';
            b[idx] = '0';
            count++;
        }
    }

    public void unfix(int idx) {
        if (a[idx] == '1') {
            a[idx] = '0';
            b[idx] = '1';
            count--;
        }
    }

    public void flip() {
        char[] temp = a;
        a = b;
        b = temp;
        count = a.length - count;
    }

    public boolean all() {
        return count == a.length;
    }

    public boolean one() {
        return count > 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        return new String(a);
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
