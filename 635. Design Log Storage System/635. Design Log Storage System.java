/*
 * Problem: 635. Design Log Storage System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-log-storage-system/
 * Language: java
 * Date: 2026-04-06
 */

class LogSystem {
    int[][] arr = new int[500][];
    int idx = 0;
    HashMap<String, Integer> HM = new HashMap<>();

    public LogSystem() {
        HM.put("Year", 1);
        HM.put("Month", 2);
        HM.put("Day", 3);
        HM.put("Hour", 4);
        HM.put("Minute", 5);
        HM.put("Second", 6);
    }

    public void put(int id, String timestamp) {
        arr[idx] = toArr(timestamp);
        arr[idx][0] = id;
        idx++;
    }

    public int[] toArr(String str) {
        String[] strs = str.split(":");
        int[] res = new int[7];
        for (int i = 0; i < strs.length; i++) {
            res[i + 1] = Integer.valueOf(strs[i]);
        }
        return res;
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        int[] l = toArr(start);
        int[] r = toArr(end);
        int lim = HM.get(granularity);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            if (chk(l, r, i, lim))
                res.add(arr[i][0]);
        }
        return res;
    }

    public boolean chk(int[] l, int[] r, int i, int lim) {
        for (int j = 1; j <= lim; j++) {
            if (arr[i][j] < l[j]) {
                return false;
            } else if (arr[i][j] > l[j]) {
                break;
            }
        }
        for (int j = 1; j <= lim; j++) {
            if (arr[i][j] > r[j]) {
                return false;
            } else if (arr[i][j] < r[j]) {
                break;
            }
        }
        return true;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
