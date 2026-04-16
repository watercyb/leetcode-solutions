/*
 * Problem: 1348. Tweet Counts Per Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/tweet-counts-per-frequency/
 * Language: java
 * Date: 2026-04-16
 */

class TweetCounts {
    HashMap<String, TreeMap<Integer, Integer>> HM = new HashMap<>();

    public TweetCounts() {

    }

    public void recordTweet(String tweetName, int time) {
        if (!HM.containsKey(tweetName)) {
            TreeMap<Integer, Integer> TM = new TreeMap<>();
            TM.put(time, 1);
            HM.put(tweetName, TM);
        } else {
            TreeMap<Integer, Integer> TM = HM.get(tweetName);
            TM.put(time, TM.getOrDefault(time, 0) + 1);
        }
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        if (!HM.containsKey(tweetName)) {
            List<Integer> res = new ArrayList<>();
            int period = freq.equals("minute") ? 60 : freq.equals("hour") ? 3600 : 86400;
            for (int i = startTime; i <= endTime; i += period) {
                res.add(0);
            }
            return res;
        } else {
            int period = freq.equals("minute") ? 60 : freq.equals("hour") ? 3600 : 86400;
            int[] arr = new int[(endTime - startTime + 1 + period - 1) / period];
            TreeMap<Integer, Integer> TM = HM.get(tweetName);
            for (Map.Entry<Integer, Integer> entry : TM.subMap(startTime, endTime + 1).entrySet()) {
                arr[(entry.getKey()-startTime) / period] += entry.getValue();
            }
            List<Integer> res = new ArrayList<>();
            for (int num : arr) {
                res.add(num);
            }
            return res;
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 =
 * obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
