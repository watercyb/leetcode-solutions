/*
 * Problem: 587. Erect the Fence
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/erect-the-fence/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3)
            return trees;
        int current = 0;
        for (int i = 1; i < trees.length; i++) {
            if (trees[i][0] < trees[current][0])
                current = i;
        }
        boolean[] seens = new boolean[trees.length];
        seens[current] = true;
        int next = (current + 1) % trees.length;
        int dist = getDist(trees[current], trees[next]);
        int[] arr = new int[trees.length];
        int idx = 0;
        for (int i = 0; i < trees.length; i++) {
            if (seens[i])
                continue;
            int XPro = getXPro(trees[current], trees[next], trees[i]);
            if (XPro > 0) {
                next = i;
                dist = getDist(trees[current], trees[next]);
                idx = 0;
            } else if (XPro == 0) {
                int distNext = getDist(trees[current], trees[i]);
                if (distNext > dist) {
                    arr[idx++] = next;
                    next = i;
                    dist = distNext;
                } else {
                    arr[idx++] = i;
                }
            }
        }
        for (int i = 0; i < idx; i++) {
            seens[arr[i]] = true;
        }
        seens[next] = true;
        int target = current;
        current = next;
        while (current != target) {
            next = target;
            dist = getDist(trees[current], trees[next]);
            idx = 0;
            for (int i = 0; i < trees.length; i++) {
                if (seens[i])
                    continue;
                int XPro = getXPro(trees[current], trees[next], trees[i]);
                if (XPro > 0) {
                    next = i;
                    dist = getDist(trees[current], trees[next]);
                    idx = 0;
                } else if (XPro == 0) {
                    int distNext = getDist(trees[current], trees[i]);
                    if (distNext > dist) {
                        arr[idx++] = next;
                        next = i;
                        dist = distNext;
                    } else {
                        arr[idx++] = i;
                    }
                }
            }
            for (int i = 0; i < idx; i++) {
                seens[arr[i]] = true;
            }
            seens[next] = true;
            current = next;
        }
        int count = 0;
        for (boolean seen : seens) {
            if (seen)
                count++;
        }
        int[][] res = new int[count][];
        idx = 0;
        for (int i = 0; i < trees.length; i++) {
            if (seens[i])
                res[idx++] = trees[i];
        }
        return res;
    }

    public int getDist(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }

    public int getXPro(int[] p1, int[] p2, int[] p3) {
        return (p2[0] - p1[0]) * (p3[1] - p2[1]) - (p3[0] - p2[0]) * (p2[1] - p1[1]);
    }
}
