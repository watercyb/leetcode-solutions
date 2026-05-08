/*
 * Problem: 3504. Longest Palindrome After Substring Concatenation II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-palindrome-after-substring-concatenation-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int longestPalindrome(String s, String t) {
        char[] chrsS = s.toCharArray();
        char[] chrsT = t.toCharArray();
        int[] arrS = chk1(chrsS);
        int[] arrT = chk2(chrsT);
        Node root = new Node();
        for (int i = 0; i < chrsS.length; i++) {
            Node node = root;
            for (int j = i; j >= 0; j--) {
                int idx = chrsS[j] - 'a';
                if (node.next[idx] == null)
                    node.next[idx] = new Node();
                node = node.next[idx];
                node.len = Math.max(arrS[i + 1], node.len);
            }
        }
        for (int i = 0; i < chrsT.length; i++) {
            Node node = root;
            int count = 0;
            int len = arrT[i];
            for (int j = i; j < chrsT.length; j++) {
                int idx = chrsT[j] - 'a';
                if (node.next[idx] == null)
                    break;
                count++;
                node = node.next[idx];
            }
            res = Math.max(2 * count + Math.max(len, node.len), res);
        }
        return res;
    }

    int res = 1;

    public int[] chk1(char[] chrs) {
        int[] arr = new int[chrs.length + 1];
        for (int i = 0; i < chrs.length; i++) {
            int count = 0;
            int l = i;
            int r = i + 1;
            arr[l + 1] = Math.max(count, arr[l + 1]);
            while (l >= 0 && r < chrs.length && chrs[l] == chrs[r]) {
                count += 2;
                l--;
                r++;
                arr[l + 1] = Math.max(count, arr[l + 1]);
            }
            res = Math.max(count, res);
            count = 1;
            l = i - 1;
            r = i + 1;
            arr[l + 1] = Math.max(count, arr[l + 1]);
            while (l >= 0 && r < chrs.length && chrs[l] == chrs[r]) {
                count += 2;
                l--;
                r++;
                arr[l + 1] = Math.max(count, arr[l + 1]);
            }
            res = Math.max(count, res);
        }
        return arr;
    }

    public int[] chk2(char[] chrs) {
        int[] arr = new int[chrs.length + 1];
        for (int i = 0; i < chrs.length - 1; i++) {
            int count = 0;
            int l = i;
            int r = i + 1;
            arr[r] = Math.max(count, arr[r]);
            while (l >= 0 && r < chrs.length && chrs[l] == chrs[r]) {
                count += 2;
                l--;
                r++;
                arr[r] = Math.max(count, arr[r]);
            }
            res = Math.max(count, res);
            count = 1;
            l = i - 1;
            r = i + 1;
            arr[r] = Math.max(count, arr[r]);
            while (l >= 0 && r < chrs.length && chrs[l] == chrs[r]) {
                count += 2;
                l--;
                r++;
                arr[r] = Math.max(count, arr[r]);
            }
            res = Math.max(count, res);
        }
        return arr;
    }
}

class Node {
    Node[] next = new Node[26];
    int len = 0;
}
