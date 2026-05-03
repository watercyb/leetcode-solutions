/*
 * Problem: 3006. Find Beautiful Indices in the Given Array I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char[] chrsS = s.toCharArray();
        char[] chrsA = a.toCharArray();
        char[] chrsB = b.toCharArray();
        List<Integer> list1 = getList(chrsS, chrsA);
        List<Integer> list2 = getList(chrsS, chrsB);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < list1.size()) {
            int idx = list1.get(i);
            while (j < list2.size() && idx - list2.get(j) > k) {
                j++;
            }
            if (j == list2.size())
                break;
            if (Math.abs(idx - list2.get(j)) <= k)
                res.add(idx);
            i++;
        }
        return res;
    }

    public int[] getLSP(char[] chrsA) {
        int[] lsp = new int[chrsA.length];
        int len = 0;
        int idx = 1;
        while (idx < chrsA.length) {
            if (chrsA[idx] == chrsA[len]) {
                len++;
                lsp[idx] = len;
                idx++;
            } else {
                if (len == 0) {
                    idx++;
                } else {
                    len = lsp[len - 1];
                }
            }
        }
        //System.out.println(Arrays.toString(lsp));
        return lsp;
    }

    public List<Integer> getList(char[] chrsA, char[] chrsB) {
        int[] lsp = getLSP(chrsB);
        List<Integer> res = new ArrayList<>();
        int len = 0;
        int idx = 0;
        while (idx < chrsA.length) {
            if (chrsA[idx] == chrsB[len]) {
                if (len == chrsB.length - 1) {
                    res.add(idx - len);
                    idx++;
                    len = lsp[len];
                } else {
                    len++;
                    idx++;
                }
            } else {
                if (len == 0) {
                    idx++;
                } else {
                    len = lsp[len - 1];
                }
            }
        }
        // System.out.println(Arrays.toString(lsp));
        return res;
    }
}
