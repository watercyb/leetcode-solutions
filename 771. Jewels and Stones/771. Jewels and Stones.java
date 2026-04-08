/*
 * Problem: 771. Jewels and Stones
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/jewels-and-stones/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
         char[] chrJe = jewels.toCharArray();
        char[] chrSt = stones.toCharArray();
        HashMap<Character, Integer> HM= new HashMap<Character, Integer>();
        for (char chr: chrSt) {
            HM.put(chr,HM.getOrDefault(chr,0)+1);
        }
        int n=0;
        for (char chr: chrJe) {
            if (HM.containsKey(chr)) {n+=HM.get(chr);}
        }
        return n;
    }
}
