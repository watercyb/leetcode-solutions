/*
 * Problem: 957. Prison Cells After N Days
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/prison-cells-after-n-days/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int target = getH(cells);
        List<Integer> list = new ArrayList<>();
        int[] indexes = new int[1 << cells.length];
        Arrays.fill(indexes, -1);
        list.add(target);
        indexes[target] = 0;
        for (int i = 0; i < n; i++) {
            next(cells);
            int h = getH(cells);
            if (indexes[h]!=-1) {
                int num = list.get((n-indexes[h]) % (i+1-indexes[h])+indexes[h]);
                for (int j = cells.length - 1; j >= 0; j--) {
                    cells[j] = num % 2;
                    num /= 2;
                }
                return cells;
            }
            indexes[h]=i+1;
            list.add(h);
        }
        return cells;
    }

    public void next(int[] arr) {
        int prv = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            int temp = arr[i];
            arr[i] = 1 - (prv ^ arr[i + 1]);
            prv = temp;
        }
        arr[0] = arr[arr.length - 1] = 0;
    }

    public int getH(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res = res * 2 + num;
        }
        return res;
    }
}
