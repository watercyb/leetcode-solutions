/*
 * Problem: 332. Reconstruct Itinerary
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reconstruct-itinerary/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> HM = new HashMap<>();
        for (List<String> ticket : tickets) {
            String a = ticket.get(0);
            String b = ticket.get(1);
            if (!HM.containsKey(a)) {
                PriorityQueue<String> PQ = new PriorityQueue<>();
                PQ.offer(b);
                HM.put(a, PQ);
            } else {
                HM.get(a).offer(b);
            }
        }
        dfs(HM, "JFK");
        return res;
    }

    List<String> res = new LinkedList<>();

    public void dfs(HashMap<String, PriorityQueue<String>> HM, String str) {
        if (HM.containsKey(str)) {
            PriorityQueue<String> PQ = HM.get(str);
            while (!PQ.isEmpty()) {
                String next = PQ.poll();
                dfs(HM, next);
            }
        }
        res.addFirst(str);
    }
}
