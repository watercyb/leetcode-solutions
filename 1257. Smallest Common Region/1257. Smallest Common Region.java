/*
 * Problem: 1257. Smallest Common Region
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-common-region/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        for (int i=regions.size()-1; i>=0; i--) {
            List<String> region = regions.get(i);
            if (region.contains(region1)) {
                region1 = region.get(0);
            }
            if (region.contains(region2)) {
                region2 = region.get(0);
            }
            if(region2.equals(region1)) {
                return region.get(0);
            }
        }
        return "";
    }
}
