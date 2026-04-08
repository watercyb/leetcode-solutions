/*
 * Problem: 715. Range Module
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/range-module/
 * Language: java
 * Date: 2026-04-08
 */

class RangeModule {
    TreeMap<Integer, Integer> TM = new TreeMap<>();

    public RangeModule() {
        TM.put(0, 0);
    }

    public void addRange(int left, int right) {
        while (true) {
            Map.Entry<Integer, Integer> tmp = TM.floorEntry(right);
            if (tmp.getValue() >= right) {
                right = tmp.getValue();
                TM.remove(tmp.getKey());
                if (tmp.getKey() <= left) {
                    left = tmp.getKey();
                    break;
                }
            } else if (tmp.getValue() >= left) {
                TM.remove(tmp.getKey());
                left = Math.min(tmp.getKey(), left);
            } else {
                break;
            }
        }
        TM.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        return TM.floorEntry(left).getValue() >= right;
    }

    public void removeRange(int left, int right) {
        while (true) {
            Map.Entry<Integer, Integer> tmp = TM.floorEntry(right - 1);
            if (tmp.getValue() >= right) {
                TM.remove(tmp.getKey());
                TM.put(right, tmp.getValue());
                if (tmp.getKey() < left) {
                    TM.put(tmp.getKey(), left);
                    break;
                }
            } else if (tmp.getValue() > left) {
                TM.remove(tmp.getKey());
                if (tmp.getKey() < left) {
                    TM.put(tmp.getKey(), left);
                    break;
                }
            } else {
                break;
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
