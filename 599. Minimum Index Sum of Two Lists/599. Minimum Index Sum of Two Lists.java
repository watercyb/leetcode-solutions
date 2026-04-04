/*
 * Problem: 599. Minimum Index Sum of Two Lists
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> l1 = new HashMap<String, Integer>();
        List<String> li = new ArrayList<String>();
        for (int i = 0; i < list1.length; i++) {
            l1.put(list1[i], i);
        }
        int min = list1.length + list2.length - 2;
        for (int i = 0; i < list2.length; i++) {
            if (l1.containsKey(list2[i])) {
                int n = l1.get(list2[i]) + i;
                if (n == min) {
                    li.add(list2[i]);
                }
                if (n < min) {
                    li.clear();
                    li.add(list2[i]);
                    min = n;
                }
            }
        }
        return li.toArray(new String[li.size()]);
        
    }
}
