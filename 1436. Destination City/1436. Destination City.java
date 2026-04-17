/*
 * Problem: 1436. Destination City
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/destination-city/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> chk=new HashSet<>();
        for (List<String> path:paths) {
            chk.add(path.get(0));
        }
        for (List<String> path:paths) {
            if (!chk.contains(path.get(1))) return path.get(1);
        }
         return null;
        
    }
}
