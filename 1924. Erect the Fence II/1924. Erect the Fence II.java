/*
 * Problem: 1924. Erect the Fence II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/erect-the-fence-ii/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public double[] outerTrees(int[][] trees) {
        if (trees.length == 1)
            return new double[] { trees[0][0], trees[0][1], 0 };
        if (trees.length == 2)
            return new double[] { (trees[0][0] + trees[1][0]) / 2, (trees[0][1] + trees[1][1]) / 2,
                    Math.abs(trees[0][0] - trees[1][0] + trees[0][1] - trees[1][1]) / 2 };
        if (trees.length == 3) {
            double[] res = getCycle(trees[0], trees[1], trees[2]);
            res[2] = Math.sqrt(res[2]);
            return res;
        }
        Random rand = new Random();
        for (int i = trees.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int[] tmp = trees[i];
            trees[i] = trees[j];
            trees[j] = tmp;
        }
        double[] res = dfs(trees, new int[3], 0, 0);
        res[2] = Math.sqrt(res[2]);
        return res;
    }

    public double[] dfs(int[][] trees, int[] arr, int i, int j) {
        if (i == trees.length || j == 3) {
            if (j == 0)
                return new double[] { 0, 0, 0 };
            if (j == 1)
                return new double[] { trees[arr[0]][0], trees[arr[0]][1], 0 };
            if (j == 2)
                return getCycle(trees[arr[0]], trees[arr[1]]);
            return getCycle(trees[arr[0]], trees[arr[1]], trees[arr[2]]);
        }
        double[] cycle = dfs(trees, arr, i + 1, j);
        if (getDist(trees[i], cycle) <= cycle[2]) {
            return cycle;
        } else if (j < arr.length) {
            arr[j++] = i;
            return dfs(trees, arr, i + 1, j);
        } else {
            return getCycle(trees[arr[0]], trees[arr[1]], trees[i]);
        }
    }

    public double getDist(int[] a, double[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    private double[] getCycle(int[] a, int[] b) {
        double cx = (a[0] + b[0]) / 2.0;
        double cy = (a[1] + b[1]) / 2.0;
        double r2 = getDist(a, new double[] { cx, cy, 0 });
        return new double[] { cx, cy, r2 };
    }

    public double[] getCycle(int[] a, int[] b, int[] c) {
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        int x3 = c[0];
        int y3 = c[1];
        long del = 2 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        if (del == 0) {
            double x = (double) (Math.max(Math.max(x1, x2), x3) + Math.min(Math.min(x1, x2), x3)) / 2;
            double y = (double) (Math.max(Math.max(y1, y2), y3) + Math.min(Math.min(y1, y2), y3)) / 2;
            double r = (x - x1) * (x - x1) + (y - y1) * (y - y1);
            return new double[] { x, y, r };
        }
        long a2 = (x1 * x1 + y1 * y1);
        long b2 = (x2 * x2 + y2 * y2);
        long c2 = (x3 * x3 + y3 * y3);
        double x = (double) (a2 * (y2 - y3) + b2 * (y3 - y1) + c2 * (y1 - y2)) / del;
        double y = (double) (a2 * (x3 - x2) + b2 * (x1 - x3) + c2 * (x2 - x1)) / del;
        double r = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
        return new double[] { x, y, r };
    }
}
