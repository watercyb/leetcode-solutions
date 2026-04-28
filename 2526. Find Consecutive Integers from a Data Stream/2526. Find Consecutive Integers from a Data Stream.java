/*
 * Problem: 2526. Find Consecutive Integers from a Data Stream
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/
 * Language: java
 * Date: 2026-04-28
 */

class DataStream {
    int value;
    int k;
    int last = 0;
    int count = 0;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (num == last) {
            count++;
        } else {
            last = num;
            count = 1;
        }
        return num == value && count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
