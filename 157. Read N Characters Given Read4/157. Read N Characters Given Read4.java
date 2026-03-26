/*
 * Problem: 157. Read N Characters Given Read4
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/read-n-characters-given-read4/
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
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int num = read4(tmp);
        int idx = 0;
        for (int i = 0; i < num; i++) {
            buf[idx++] = tmp[i];
        }
        System.out.println(Arrays.toString(buf));
        int res = num;
        while (num > 0) {
            if (res >= n)
                return n;
            num = read4(tmp);
            for (int i = 0; i < num; i++) {
                buf[idx++] = tmp[i];
            }
            res += num;
        }
        return res;
    }
}
