/*
 * Problem: 359. Logger Rate Limiter
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/logger-rate-limiter/
 * Language: java
 * Date: 2026-04-03
 */

class Logger {
    HashMap<String, Integer> HM = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer tmp = HM.get(message);
        if (tmp == null || timestamp >= tmp) {
            HM.put(message, timestamp + 10);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
