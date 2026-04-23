/*
 * Problem: 2034. Stock Price Fluctuation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/stock-price-fluctuation/
 * Language: java
 * Date: 2026-04-23
 */

class StockPrice {
    HashMap<Integer, int[]> HM = new HashMap<>();
    PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    int current = -1;

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if (HM.containsKey(timestamp))
            HM.get(timestamp)[1] = -1;
        int[] tmp = new int[] { price, timestamp };
        HM.put(timestamp, tmp);
        min.offer(tmp);
        max.offer(tmp);
        if (timestamp > current)
            current = timestamp;
    }

    public int current() {
        return HM.get(current)[0];
    }

    public int maximum() {
        while (max.peek()[1] == -1) {
            max.poll();
        }
        return max.peek()[0];
    }

    public int minimum() {
        while (min.peek()[1] == -1) {
            min.poll();
        }
        return min.peek()[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
