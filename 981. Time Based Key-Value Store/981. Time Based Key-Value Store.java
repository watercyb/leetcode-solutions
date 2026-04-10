/*
 * Problem: 981. Time Based Key-Value Store
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/time-based-key-value-store/
 * Language: java
 * Date: 2026-04-10
 */

class TimeMap {
    List<Stmp> Li;

    public TimeMap() {
        Li = new ArrayList<>();
    }

    public void set(String key, String value, int timestamp) {
        Li.add(new Stmp(key, timestamp, value));
    }

    public String get(String key, int timestamp) {
        int l = 0;
        int r = Li.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (Li.get(mid).timestamp > timestamp) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l--;
        while (l >= 0) {
            if (Li.get(l).key.equals(key))
                return Li.get(l).value;
            l--;
        }
        return "";
    }
}

class Stmp {
    String key;
    int timestamp;
    String value;

    public Stmp(String key, int timestamp, String value) {
        this.key = key;
        this.timestamp = timestamp;
        this.value = value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
