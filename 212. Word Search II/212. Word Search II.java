/*
 * Problem: 212. Word Search II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/word-search-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Tire root = new Tire();
        for (String word : words) {
            insert(word, root);
        }
        List<String> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                count += dfs(res, board, root.next[board[i][j]], i, j);
                if (count == root.counts)
                    return res;
            }
        }
        return res;
    }

    public int dfs(List<String> res, char[][] board, Tire node, int i, int j) {
        char tmp = board[i][j];
        int count = 0;
        if (tmp == '#' || node == null)
            return count;
        if (node.word != "") {
            res.add(node.word);
            node.word = "";
            count++;
        }
        board[i][j] = '#';
        if (i > 0)
            count += dfs(res, board, node.next[board[i - 1][j]], i - 1, j);
        if (j > 0)
            count += dfs(res, board, node.next[board[i][j - 1]], i, j - 1);
        if (i < board.length - 1)
            count += dfs(res, board, node.next[board[i + 1][j]], i + 1, j);
        if (j < board[0].length - 1)
            count += dfs(res, board, node.next[board[i][j + 1]], i, j + 1);
        if (count == node.counts) {
            board[i][j] = tmp;
            return count;
        }
        board[i][j] = tmp;
        return count;
    }

    public void insert(String word, Tire node) {
        char[] chrs=word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            node.counts++;
            if (node.next[chrs[i]] == null)
                node.next[chrs[i]] = new Tire();
            node = node.next[chrs[i]];
        }
        node.counts++;
        node.word = word;
    }
}

class Tire {
    int counts = 0;
    String word = "";
    Tire[] next = new Tire['z' + 1];
}
