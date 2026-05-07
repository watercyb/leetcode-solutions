/*
 * Problem: 3441. Minimum Cost Good Caption
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-good-caption/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public String minCostGoodCaption(String caption) {
        if (caption.length() < 3)
            return "";
        char[] chrs = caption.toCharArray();
        Sort sort = new Sort();
        Node DP1 = new Node(Integer.MAX_VALUE / 2, '#', "", 0);
        Node DP2 = new Node(Integer.MAX_VALUE / 2, '#', "", 0);
        Node DP3 = new Node(sort.get3(chrs[0], chrs[1], chrs[2]), sort.arr[1], "", 3);
        if (chrs.length == 3)
            return DP3.str;
        sort = new Sort();
        sort.get3(chrs[1], chrs[2], chrs[3]);
        Node DP4 = new Node(sort.get4(chrs[0]), sort.arr[2], "", 4);
        if (chrs.length == 4)
            return DP4.str;
        sort = new Sort();
        sort.get3(chrs[2], chrs[3], chrs[4]);
        sort.get4(chrs[1]);
        Node DP5 = new Node(sort.get5(chrs[0]), sort.arr[2], "", 5);
        for (int i = 5; i < chrs.length; i++) {
            sort = new Sort();
            Node DPNext = new Node(sort.get3(chrs[i], chrs[i - 1], chrs[i - 2]) + DP3.num, sort.arr[1], DP3.str, 3);
            if (i > 2)
                DPNext.insert(sort.get4(chrs[i - 3]) + DP2.num, sort.arr[2], DP2.str, 4);
            if (i > 3)
                DPNext.insert(sort.get5(chrs[i - 4]) + DP1.num, sort.arr[2], DP1.str, 5);
            DP1 = DP2;
            DP2 = DP3;
            DP3 = DP4;
            DP4 = DP5;
            DP5 = DPNext;
        }
        return DP5.str;
    }
}

class Node {
    int num;
    char chr;
    int idx;
    String str;

    public Node(int num, char chr, String str, int n) {
        this.num = num;
        this.chr = chr;
        StringBuilder SB = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            SB.append(chr);
        }
        this.str = SB.toString();
    }

    public void insert(int num, char chr, String str, int n) {
        if (num < this.num) {
            this.num = num;
            this.chr = chr;
            StringBuilder SB = new StringBuilder(str);
            for (int i = 0; i < n; i++) {
                SB.append(chr);
            }
            str = SB.toString();
            this.str = str;
        } else if (num == this.num) {
            StringBuilder SB = new StringBuilder(str);
            for (int i = 0; i < n; i++) {
                SB.append(chr);
            }
            str = SB.toString();
            if (str.compareTo(this.str) < 0) {
                this.num = num;
                this.chr = chr;
                this.str = str;
            }
        }
    }
}

class Sort {
    char[] arr = new char[5];

    public int get3(char a, char b, char c) {
        if (b > a) {
            arr[1] = a;
            arr[0] = b;
        } else {
            arr[0] = a;
            arr[1] = b;
        }
        if (c > arr[0]) {
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = c;
        } else if (c > arr[1]) {
            arr[2] = arr[1];
            arr[1] = c;
        } else {
            arr[2] = c;
        }
        return arr[0] - arr[2];
    }

    public int get4(char a) {
        if (a > arr[0]) {
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = a;
        } else if (a > arr[1]) {
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = a;
        } else if (a > arr[2]) {
            arr[3] = arr[2];
            arr[2] = a;
        } else {
            arr[3] = a;
        }
        return arr[0] - arr[3] + arr[1] - arr[2];
    }

    public int get5(char a) {
        if (a > arr[0]) {
            arr[4] = arr[3];
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = arr[0];
            arr[0] = a;
        } else if (a > arr[1]) {
            arr[4] = arr[3];
            arr[3] = arr[2];
            arr[2] = arr[1];
            arr[1] = a;
        } else if (a > arr[2]) {
            arr[4] = arr[3];
            arr[3] = arr[2];
            arr[2] = a;
        } else if (a > arr[3]) {
            arr[4] = arr[3];
            arr[3] = a;
        } else {
            arr[4] = a;
        }
        return arr[0] - arr[4] + arr[1] - arr[3];
    }
}
