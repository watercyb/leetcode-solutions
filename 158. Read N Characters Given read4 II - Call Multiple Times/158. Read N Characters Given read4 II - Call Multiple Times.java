/*
 * Problem: 158. Read N Characters Given read4 II - Call Multiple Times
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 * Language: java
 * Date: 2026-03-26
 */

/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */

    char[] buf4 = new char[4];
    int idx4 = 0;
    int count = 0;

    public int read(char[] buf, int n) {
        int idx = 0;
        while (idx < n) {
            if (idx4 == count) {
                count = read4(buf4);
                idx4 = 0;
                if (count == 0)
                    break;
            }
            buf[idx++] = buf4[idx4++];
        }
        return idx;
    }
}
