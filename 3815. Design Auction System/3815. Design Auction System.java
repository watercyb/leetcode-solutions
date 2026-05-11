/*
 * Problem: 3815. Design Auction System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-auction-system/
 * Language: java
 * Date: 2026-05-11
 */

class AuctionSystem {
    HashMap<Long, Integer> bidAmounts = new HashMap<>();
    HashMap<Integer, PriorityQueue<int[]>> items = new HashMap<>();

    public AuctionSystem() {

    }

    public void addBid(int userId, int itemId, int bidAmount) {
        long h = getH(userId, itemId);
        bidAmounts.put(h, bidAmount);
        if (!items.containsKey(itemId)) {
            PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
            PQ.offer(new int[] { userId, bidAmount });
            items.put(itemId, PQ);
        } else {
            PriorityQueue<int[]> PQ = items.get(itemId);
            PQ.offer(new int[] { userId, bidAmount });
        }
    }

    public long getH(int userId, int itemId) {
        return (long) userId * 1000000 + itemId;
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }

    public void removeBid(int userId, int itemId) {
        long h = getH(userId, itemId);
        bidAmounts.remove(h);
    }

    public int getHighestBidder(int itemId) {
        if (!items.containsKey(itemId))
            return -1;
        PriorityQueue<int[]> PQ = items.get(itemId);
        while (!PQ.isEmpty() && bidAmounts.getOrDefault(getH(PQ.peek()[0], itemId), -1) != PQ.peek()[1]) {
            PQ.poll();
        }
        if (PQ.isEmpty())
            return -1;
        return PQ.peek()[0];
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */
