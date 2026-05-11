/*
 * Problem: 3822. Design Order Management System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-order-management-system/
 * Language: java
 * Date: 2026-05-11
 */

class OrderManagementSystem {
    int[] idToTypes = new int[20001];
    int[] idToPrices = new int[20001];
    HashMap<Long, HashSet<Integer>> HM = new HashMap<>();

    public OrderManagementSystem() {

    }

    public int getType(String orderType) {
        if (orderType.equals("buy")) {
            return 0;
        } else {
            return 1;
        }
    }

    public long getH(int type, int price) {
        return ((long) price << 1) + type;
    }

    public void addOrder(int orderId, String orderType, int price) {
        int type = getType(orderType);
        idToTypes[orderId] = type;
        idToPrices[orderId] = price;
        long h = getH(type, price);
        if (!HM.containsKey(h)) {
            HashSet<Integer> HS = new HashSet<>();
            HS.add(orderId);
            HM.put(h, HS);
        } else {
            HM.get(h).add(orderId);
        }
    }

    public void modifyOrder(int orderId, int newPrice) {
        int type = idToTypes[orderId];
        int price = idToPrices[orderId];
        idToPrices[orderId] = newPrice;
        HM.get(getH(type, price)).remove(orderId);
        long h = getH(type, newPrice);
        if (!HM.containsKey(h)) {
            HashSet<Integer> HS = new HashSet<>();
            HS.add(orderId);
            HM.put(h, HS);
        } else {
            HM.get(h).add(orderId);
        }
    }

    public void cancelOrder(int orderId) {
        int type = idToTypes[orderId];
        int price = idToPrices[orderId];
        HM.get(getH(type, price)).remove(orderId);
    }

    public int[] getOrdersAtPrice(String orderType, int price) {
        HashSet<Integer> HS = HM.getOrDefault(getH(getType(orderType), price), new HashSet<>());
        int[] res = new int[HS.size()];
        int idx = 0;
        for (int id : HS) {
            res[idx++] = id;
        }
        return res;
    }
}

/**
 * Your OrderManagementSystem object will be instantiated and called as such:
 * OrderManagementSystem obj = new OrderManagementSystem();
 * obj.addOrder(orderId,orderType,price);
 * obj.modifyOrder(orderId,newPrice);
 * obj.cancelOrder(orderId);
 * int[] param_4 = obj.getOrdersAtPrice(orderType,price);
 */
