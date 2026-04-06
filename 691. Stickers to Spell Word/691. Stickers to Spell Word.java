/*
 * Problem: 691. Stickers to Spell Word
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stickers-to-spell-word/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int minStickers(String[] stickers, String target) {
        int[] counts = new int['z' + 1];
        int count = 0;
        for (char chr : target.toCharArray()) {
            if (counts[chr]++ == 0)
                count++;
        }
        int[] t = new int[count];
        int idx = 0;
        int[] links = new int['z' + 1];
        Arrays.fill(links, -1);
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] > 0) {
                links[i] = idx;
                t[idx++] = counts[i];
            }
        }
        int[][] stickersList = new int[stickers.length][count];
        boolean[] notUsing = new boolean[stickers.length];
        count = 0;
        for (int i = 0; i < stickers.length; i++) {
            count++;
            for (char chr : stickers[i].toCharArray()) {
                if (links[chr] != -1)
                    stickersList[i][links[chr]]++;
            }
            for (int j = 0; j < i; j++) {
                if (notUsing[j])
                    continue;
                boolean larger = false;
                boolean smaller = false;
                for (int k = 0; k < stickersList[0].length; k++) {
                    if (stickersList[i][k] > stickersList[j][k]) {
                        larger = true;
                    } else if (stickersList[i][k] < stickersList[j][k]) {
                        smaller = true;
                    }
                }
                if (larger && !smaller) {
                    notUsing[j] = true;
                    count--;
                } else if (!larger && smaller) {
                    notUsing[i] = true;
                    count--;
                    break;
                }
            }
        }
        int[][] stickersArray = new int[count][stickersList[0].length];
        idx = 0;
        for (int i = 0; i < stickersList.length; i++) {
            if (!notUsing[i])
                stickersArray[idx++] = stickersList[i];
        }
        dfs(stickersArray, t, 0, 0);
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    int res = Integer.MAX_VALUE;

    public void dfs(int[][] stickersArray, int[] t, int i, int n) {
        if (n >= res)
            return;
        if (i == stickersArray.length) {
            for (int num : t) {
                if (num > 0)
                    return;
            }
            res = n;
            return;
        }
        int count = 0;
        for (int j = 0; j < t.length; j++) {
            if (stickersArray[i][j] == 0 || t[j] <= 0)
                continue;
            count = Math.max((t[j] - 1) / stickersArray[i][j] + 1, count);
        }
        dfs(stickersArray, t, i + 1, n);
        for (int j = 1; j <= count; j++) {
            for (int k = 0; k < t.length; k++) {
                t[k] -= stickersArray[i][k];
            }
            dfs(stickersArray, t, i + 1, n + j);
        }
        for (int j = 0; j < t.length; j++) {
            t[j] += stickersArray[i][j] * count;
        }
    }
}
