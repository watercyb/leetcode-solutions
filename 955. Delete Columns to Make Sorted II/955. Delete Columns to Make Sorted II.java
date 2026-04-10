/*
 * Problem: 955. Delete Columns to Make Sorted II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int res = 0;
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { 0, strs.length - 1 });
        for (int i = 0; i < len && !list.isEmpty(); i++) {
            List<int[]> listNext = chk(strs, list, i);
            if (listNext == null) {
                res++;
            } else {
                list = listNext;
            }
        }
        return res;
    }

    public List<int[]> chk(String[] strs, List<int[]> list, int i) {
        List<int[]> res = new ArrayList<>();
        for (int[] pair : list) {
            List<int[]> li = chk(strs, i, pair[0], pair[1]);
            if (li == null)
                return null;
            res.addAll(li);
        }
        return res;
    }

    public List<int[]> chk(String[] strs, int i, int l, int r) {
        char prv = strs[l].charAt(i);
        int idx = l;
        List<int[]> res = new ArrayList<>();
        while (l <= r) {
            if (strs[l].charAt(i) < prv)
                return null;
            if (strs[l].charAt(i) > prv) {
                if (l - idx > 1)
                    res.add(new int[] { idx, l - 1 });
                idx = l;
                prv = strs[l].charAt(i);
            }
            l++;
        }
        if (r - idx > 0)
            res.add(new int[] { idx, r });
        return res;
    }
}
