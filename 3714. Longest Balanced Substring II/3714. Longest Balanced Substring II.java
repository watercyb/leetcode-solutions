/*
 * Problem: 3714. Longest Balanced Substring II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-balanced-substring-ii/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int longestBalanced(String s) {
        char[] chrs = s.toCharArray();
        int res = Math.max(getOne(chrs), getThree(chrs));
        res = Math.max(res, getTwo(chrs, 'a', 'b'));
        res = Math.max(res, getTwo(chrs, 'b', 'c'));
        res = Math.max(res, getTwo(chrs, 'a', 'c'));
        return res;
    }

    public int getOne(char[] chrs) {
        int a = 0;
        int b = 0;
        int c = 0;
        int res = 0;
        for (char chr : chrs) {
            if (chr == 'a') {
                a++;
                b = 0;
                c = 0;
                res = Math.max(res, a);
            } else if (chr == 'b') {
                b++;
                a = 0;
                c = 0;
                res = Math.max(res, b);
            } else {
                c++;
                a = 0;
                b = 0;
                res = Math.max(res, c);
            }
        }
        return res;
    }

    public int getTwo(char[] chrs, char a, char b) {
        int h = chrs.length;
        int[] arr = new int[2 * h + 1];
        Arrays.fill(arr, -2);
        arr[chrs.length] = -1;
        int res = 0;
        int lim = -1;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == a) {
                h++;
            } else if (chrs[i] == b) {
                h--;
            } else {
                lim = i;
                arr[chrs.length] = i;
                h = chrs.length;
            }
            int idx = arr[h];
            if (idx < lim) {
                arr[h] = i;
            } else {
                res = Math.max(res, i - idx);
            }
        }
        return res;
    }

    public int getThree(char[] chrs) {
        long l = 2 * chrs.length + 1;
        long h = chrs.length * l + chrs.length;
        HashMap<Long, Integer> HM = new HashMap<>(chrs.length, 0.99f);
        HM.put(h, -1);
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 'a') {
                h += l + 1;
            } else if (chrs[i] == 'b') {
                h -= l;
            } else {
                h--;
            }
            if (HM.containsKey(h)) {
                res = Math.max(res, i - HM.get(h));
            } else {
                HM.put(h, i);
            }
        }
        return res;
    }
}
