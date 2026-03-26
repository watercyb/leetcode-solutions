/*
 * Problem: 170. Two Sum III - Data structure design
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * Language: java
 * Date: 2026-03-26
 */

class TwoSum {
    HashMap<Integer, Integer> HM = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public TwoSum() {

    }

    public void add(int number) {
        HM.put(number, HM.getOrDefault(number, 0) + 1);
        max = Math.max(number, max);
        min = Math.min(number, min);
    }

    public boolean find(int value) {
        if (value > 0) {
            if (value > 2 * max || value < min)
                return false;
        } else {
            if (value > max || value < 2 * min)
                return false;
        }
        for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            int diff = value - k;
            if ((diff != k && HM.containsKey(diff)) || (diff == k && v >= 2))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
