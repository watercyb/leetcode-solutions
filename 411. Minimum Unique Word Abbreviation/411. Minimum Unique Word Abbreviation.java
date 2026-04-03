/*
 * Problem: 411. Minimum Unique Word Abbreviation
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-unique-word-abbreviation/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        char[] chrs = target.toCharArray();
        List<String> list = new ArrayList<>();
        for (String str : dictionary) {
            if (str.length() == chrs.length) {
                list.add(str);
            }
        }
        if (list.isEmpty())
            return String.valueOf(chrs.length);
        char[][] dict = new char[list.size()][];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = list.get(i).toCharArray();
        }
        res = target;
        char[] resList = new char[chrs.length];
        Arrays.fill(resList, '#');
        int l = 1;
        int r = chrs.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (dfs(chrs, dict, resList, 0, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    String res;

    public boolean dfs(char[] chrs, char[][] dict, char[] resList, int i, int n) {
        if (i == chrs.length) {
            if (n == 0 && !chk(dict, resList))
                return true;
            return false;
        }
        if (i == 0) {
            resList[i] = chrs[i];
            if (n > 0 && dfs(chrs, dict, resList, i + 1, n - 1)) {
                resList[i] = '#';
                return true;
            }
            resList[i] = '#';
            if (dfs(chrs, dict, resList, i + 1, n))
                return true;
        } else {
            if (dfs(chrs, dict, resList, i + 1, n))
                return true;
            resList[i] = chrs[i];
            if (n > 0 && dfs(chrs, dict, resList, i + 1, n - 1)) {
                resList[i] = '#';
                return true;
            }
            resList[i] = '#';
        }
        return false;
    }

    public boolean chk(char[][] dict, char[] resList) {
        for (char[] chrs : dict) {
            if (isAbbr(chrs, resList))
                return true;
        }
        StringBuilder SB = new StringBuilder();
        int count = 0;
        for (char chr : resList) {
            if (chr != '#') {
                if (count > 0)
                    SB.append(count);
                SB.append(chr);
                count = 0;
            } else {
                count++;
            }
        }
        if (count > 0)
            SB.append(count);
        res = SB.toString();
        return false;
    }

    public boolean isAbbr(char[] chrs, char[] resList) {
        for (int i = 0; i < resList.length; i++) {
            if (resList[i] != '#' && chrs[i] != resList[i])
                return false;
        }
        return true;
    }
}

class Node {
    char chr = '#';
    int num = 0;

    public Node(char chr) {
        this.chr = chr;
    }

    public Node(int num) {
        this.num = num;
    }
}
