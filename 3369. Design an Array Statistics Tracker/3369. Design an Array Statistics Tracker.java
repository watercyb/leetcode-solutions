/*
 * Problem: 3369. Design an Array Statistics Tracker
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-an-array-statistics-tracker/
 * Language: java
 * Date: 2026-05-06
 */

class StatisticsTracker {
    Queue<Integer> Qu = new LinkedList<>();
    TreeMap<Integer, Integer> TM1 = new TreeMap<>();
    TreeMap<Integer, Integer> TM2 = new TreeMap<>();
    int l = 0;
    int r = 0;
    PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    HashMap<Integer, Integer> HM = new HashMap<>();
    long sum = 0;

    public StatisticsTracker() {
        TM1.put(Integer.MIN_VALUE, 0);
        TM2.put(Integer.MAX_VALUE, 0);
    }

    public void addNumber(int number) {
        Qu.offer(number);
        if (number < TM1.lastKey()) {
            if (l == r) {
                offer(TM2, pollLast(TM1));
                l--;
                r++;
            }
            offer(TM1, number);
            l++;
        } else if (number > TM2.firstKey()) {
            if (l < r) {
                offer(TM1, pollFirst(TM2));
                l++;
                r--;
            }
            offer(TM2, number);
            r++;
        } else {
            if (l < r) {
                offer(TM1, number);
                l++;
            } else {
                offer(TM2, number);
                r++;
            }
        }
        int n = HM.getOrDefault(number, 0);
        HM.put(number, n + 1);
        PQ.offer(new int[] { n + 1, number });
        sum += number;
    }

    public void offer(TreeMap<Integer, Integer> TM, int num) {
        if (TM.containsKey(num)) {
            TM.put(num, TM.get(num) + 1);
        } else {
            TM.put(num, 1);
        }
    }

    public int pollFirst(TreeMap<Integer, Integer> TM) {
        Map.Entry<Integer, Integer> entry = TM.firstEntry();
        if (entry.getValue() == 1) {
            TM.remove(entry.getKey());
        } else {
            TM.put(entry.getKey(), entry.getValue() - 1);
        }
        return entry.getKey();
    }

    public int pollLast(TreeMap<Integer, Integer> TM) {
        Map.Entry<Integer, Integer> entry = TM.lastEntry();
        if (entry.getValue() == 1) {
            TM.remove(entry.getKey());
        } else {
            TM.put(entry.getKey(), entry.getValue() - 1);
        }
        return entry.getKey();
    }

    public void removeFirstAddedNumber() {
        int number = Qu.poll();
        if (number >= TM2.firstKey()) {
            remove(TM2, number);
            r--;
        } else {
            remove(TM1, number);
            l--;
        }
        if (l < r - 1) {
            offer(TM1, pollFirst(TM2));
            l++;
            r--;
        } else if (l > r) {
            offer(TM2, pollLast(TM1));
            l--;
            r++;
        }
        int n = HM.get(number);
        HM.put(number, n - 1);
        PQ.offer(new int[] { n - 1, number });
        sum -= number;
    }

    public void remove(TreeMap<Integer, Integer> TM, int num) {
        int n = TM.get(num);
        if (n == 1) {
            TM.remove(num);
        } else {
            TM.put(num, n - 1);
        }
    }

    public int getMean() {
        return (int) (sum / Qu.size());
    }

    public int getMedian() {
        return TM2.firstKey();
    }

    public int getMode() {
        while (true) {
            int[] pair = PQ.peek();
            if (HM.get(pair[1]) == pair[0])
                return pair[1];
            PQ.poll();
        }
    }
}

/**
 * Your StatisticsTracker object will be instantiated and called as such:
 * StatisticsTracker obj = new StatisticsTracker();
 * obj.addNumber(number);
 * obj.removeFirstAddedNumber();
 * int param_3 = obj.getMean();
 * int param_4 = obj.getMedian();
 * int param_5 = obj.getMode();
 */
