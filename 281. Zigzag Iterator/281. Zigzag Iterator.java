/*
 * Problem: 281. Zigzag Iterator
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zigzag-iterator/?envType=weekly-question&envId=2026-04-22
 * Language: java
 * Date: 2026-04-22
 */

public class ZigzagIterator {
    List<Integer>[] v = new ArrayList[2];
    int[] idx = new int[2];
    int turn = 0;
    int count;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v[0] = v1;
        v[1] = v2;
        count = v1.size() + v2.size();
        if (count == 0)
            return;
        if (idx[0] == v[0].size())
            turn = 1;
    }

    public int next() {
        if (count-- <= 0)
            return -1;
        int res = v[turn].get(idx[turn]++);
        if (idx[1 - turn] < v[1 - turn].size())
            turn = 1 - turn;
        return res;
    }

    public boolean hasNext() {
        return count > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
