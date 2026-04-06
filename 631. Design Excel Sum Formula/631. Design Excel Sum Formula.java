/*
 * Problem: 631. Design Excel Sum Formula
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-excel-sum-formula/
 * Language: java
 * Date: 2026-04-06
 */

class Excel {
    int[][] nums;
    List<int[]>[][] links;
    int[][] vers;

    public Excel(int height, char width) {
        nums = new int[height][width - 'A' + 1];
        links = new ArrayList[height][width - 'A' + 1];
        for (int i = 0; i < links.length; i++) {
            for (int j = 0; j < links[0].length; j++) {
                links[i][j] = new ArrayList<>();
            }
        }
        vers = new int[height][width - 'A' + 1];
    }

    public void set(int row, char column, int val) {
        int[] idx = { row - 1, column - 'A' };
        vers[idx[0]][idx[1]]++;
        int diff = val - nums[idx[0]][idx[1]];
        nums[idx[0]][idx[1]] = val;
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(idx);
        while (!Qu.isEmpty()) {
            int[] tmp = Qu.poll();
            for (int i = 0; i < links[tmp[0]][tmp[1]].size(); i++) {
                int[] next = links[tmp[0]][tmp[1]].get(i);
                if (next[2] < vers[next[0]][next[1]]) {
                    links[tmp[0]][tmp[1]].remove(i);
                    i--;
                    continue;
                }
                nums[next[0]][next[1]] += diff;
                Qu.offer(new int[] { next[0], next[1] });
            }
        }
    }

    public void set(int row, int column, int val) {
        int[] idx = { row, column };
        int diff = val - nums[idx[0]][idx[1]];
        nums[idx[0]][idx[1]] = val;
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(idx);
        while (!Qu.isEmpty()) {
            int[] tmp = Qu.poll();
            for (int i = 0; i < links[tmp[0]][tmp[1]].size(); i++) {
                int[] next = links[tmp[0]][tmp[1]].get(i);
                if (next[2] < vers[next[0]][next[1]]) {
                    links[tmp[0]][tmp[1]].remove(i);
                    i--;
                    continue;
                }
                nums[next[0]][next[1]] += diff;
                Qu.offer(new int[] { next[0], next[1] });
            }
        }
    }

    public int get(int row, char column) {
        return nums[row - 1][column - 'A'];
    }

    public int sum(int row, char column, String[] numbers) {
        int[] idx = { row - 1, column - 'A', 0 };
        int res = 0;
        vers[idx[0]][idx[1]]++;
        idx[2] = vers[idx[0]][idx[1]];
        for (String str : numbers) {
            int[] tmp = getIdx(str);
            if (tmp.length > 2 && (tmp[0] != tmp[2] || tmp[1] != tmp[3])) {
                for (int i = tmp[0]; i <= tmp[2]; i++) {
                    for (int j = tmp[1]; j <= tmp[3]; j++) {
                        res += nums[i][j];
                        links[i][j].add(idx);
                    }
                }
            } else {
                res += nums[tmp[0]][tmp[1]];
                links[tmp[0]][tmp[1]].add(idx);
            }
        }
        set(idx[0], idx[1], res);
        return nums[idx[0]][idx[1]];
    }

    public int[] getIdx(String str) {
        String[] strs = str.split(":", 0);
        if (strs.length > 1) {
            return new int[] { Integer.valueOf(strs[0].substring(1, strs[0].length())) - 1, strs[0].charAt(0) - 'A',
                    Integer.valueOf(strs[1].substring(1, strs[1].length())) - 1, strs[1].charAt(0) - 'A' };
        } else {
            return new int[] { Integer.valueOf(strs[0].substring(1, strs[0].length())) - 1, strs[0].charAt(0) - 'A' };
        }
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
