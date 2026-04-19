/*
 * Problem: 1656. Design an Ordered Stream
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/design-an-ordered-stream/
 * Language: java
 * Date: 2026-04-19
 */

class OrderedStream {
    String[] strs;
    int idx = 1;

    public OrderedStream(int n) {
        strs = new String[n + 1];
    }

    public String[] insert(int idKey, String value) {
        strs[idKey] = value;
        int tmp = idx;
        while (idx < strs.length && strs[idx] != null) {
            idx++;
        }
        return Arrays.copyOfRange(strs, tmp, idx);
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
