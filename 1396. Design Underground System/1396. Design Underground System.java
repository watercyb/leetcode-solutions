/*
 * Problem: 1396. Design Underground System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-underground-system/
 * Language: java
 * Date: 2026-04-16
 */

class UndergroundSystem {
    HashMap<String, HashMap<String, int[]>> HM = new HashMap<>();
    HashMap<Integer, Node> HM1 = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        HM1.put(id, new Node(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Node node = HM1.get(id);
        HashMap<String, int[]> HMTmp = HM.getOrDefault(node.station, new HashMap<String, int[]>());
        int[] arr = HMTmp.getOrDefault(stationName, new int[2]);
        arr[0] += t - node.t;
        arr[1]++;
        HMTmp.put(stationName, arr);
        HM.put(node.station, HMTmp);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] arr = HM.get(startStation).get(endStation);
        return 1.0 * arr[0] / arr[1];
    }
}

class Node {
    String station;
    int t;

    public Node(String station, int t) {
        this.station = station;
        this.t = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
