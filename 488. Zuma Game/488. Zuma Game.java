/*
 * Problem: 488. Zuma Game
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/zuma-game/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMinStep(String board, String hand) {
        char[] chrsBoard = board.toCharArray();
        char[] chrsHand = hand.toCharArray();
        char[] chrs = new char['Z'];
        chrs['R'] = 'A';
        chrs['Y'] = 'B';
        chrs['B'] = 'C';
        chrs['G'] = 'D';
        chrs['W'] = 'E';
        int[] countsBoard = new int['F'];
        int[] countsHand = new int['F'];
        for (int i = 0; i < chrsBoard.length; i++) {
            chrsBoard[i] = chrs[chrsBoard[i]];
            countsBoard[chrsBoard[i]]++;
        }
        for (char chr : chrsHand) {
            countsHand[chrs[chr]]++;
        }
        for (int i = 'A'; i <= 'E'; i++) {
            if (countsBoard[i] > 0 && countsBoard[i] + countsHand[i] < 3)
                return -1;
        }
        int res = dfs(new String(chrsBoard), countsHand, chrsHand.length, new HashMap<>());
        if (res >= Integer.MAX_VALUE / 2)
            return -1;
        return res;
    }

    public int dfs(String board, int[] countsHand, int n, HashMap<String, Integer> HM) {
        if (board.isEmpty())
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE / 2;
        StringBuilder SB = new StringBuilder(board).append('#');
        for (int i = 'A'; i <= 'E'; i++) {
            SB.append(countsHand[i]);
        }
        String k = SB.toString();
        if (HM.containsKey(k))
            return HM.get(k);
        char[] chrsBoard = board.toCharArray();
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < chrsBoard.length; i++) {
            for (char j = 'A'; j <= 'E'; j++) {
                if (countsHand[j] > 0 && (chrsBoard[i] == j && (i == chrsBoard.length - 1 || chrsBoard[i + 1] != j)
                        || (i < chrsBoard.length - 1 && chrsBoard[i] != j && chrsBoard[i] == chrsBoard[i + 1]))) {
                    String boardNext = getStr(chrsBoard, j, i);
                    countsHand[j]--;
                    res = Math.min(dfs(boardNext, countsHand, n - 1, HM) + 1, res);
                    countsHand[j]++;
                }
            }
        }
        HM.put(k, res);
        return res;
    }

    public String getStr(String board, char chr, int i) {
        int l = i;
        int r = i + 1;
        int count = -1;
        while (true) {
            int left = l;
            int right = r;
            while (l >= 0 && board.charAt(l) == chr) {
                l--;
            }
            while (r < board.length() && board.charAt(r) == chr) {
                r++;
            }
            if (r - l - 1 - count >= 3) {
                count = r - l - 1;
                if (l < 0 || r == board.length()) {
                    StringBuilder SB = new StringBuilder();
                    if (l >= 0)
                        SB.append(board.substring(0, l + 1));
                    if (r < board.length())
                        SB.append(board.substring(r));
                    return SB.toString();
                }
                chr = board.charAt(l);
            } else {
                StringBuilder SB = new StringBuilder();
                if (left >= 0)
                    SB.append(board.substring(0, left + 1));
                if (count == -1)
                    SB.append(chr);
                if (right < board.length())
                    SB.append(board.substring(right));
                return SB.toString();
            }
        }
    }

    public String getStr(char[] charsBoard, char chr, int i) {
        int l = i;
        int r = i + 1;
        int count = -1;
        while (true) {
            int left = l;
            int right = r;
            while (l >= 0 && charsBoard[l] == chr) {
                l--;
            }
            while (r < charsBoard.length && charsBoard[r] == chr) {
                r++;
            }
            if (r - l - 1 - count >= 3) {
                count = r - l - 1;
                if (l < 0 || r == charsBoard.length) {
                    StringBuilder SB = new StringBuilder();
                    if (l >= 0)
                        SB.append(new String(charsBoard, 0, l + 1));
                    if (r < charsBoard.length)
                        SB.append(new String(charsBoard, r, charsBoard.length - r));
                    return SB.toString();
                }
                chr = charsBoard[l];
            } else {
                StringBuilder SB = new StringBuilder();
                if (left >= 0)
                    SB.append(new String(charsBoard, 0, left + 1));
                if (count == -1)
                    SB.append(chr);
                if (right < charsBoard.length)
                    SB.append(new String(charsBoard, right, charsBoard.length - right));
                return SB.toString();
            }
        }
    }
}
