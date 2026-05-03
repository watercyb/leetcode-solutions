/*
 * Problem: 3008. Find Beautiful Indices in the Given Array II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
     public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int currentIndex = 0;
        List<Integer> aIndecies = new ArrayList();
        int indexA = checkString(a);
        int indexB = checkString(b);
        int slength = s.length();
        int blength = b.length();
        int alength = a.length();
        while (true){
            int newIndex = s.indexOf(a, currentIndex);
            if (newIndex == -1 || newIndex > slength - alength)
                break;
            aIndecies.add(newIndex);
            if(indexA != -1)
                currentIndex = newIndex + indexA;
            else {
                for(int i = 1; i < alength; i++){
                    if (newIndex + i > slength - alength)
                        break;
                    aIndecies.add(newIndex + i);
                }
                currentIndex = newIndex + alength;
            }
        }
        List<Integer> bIndecies = new ArrayList();
        currentIndex = 0;
        while (true){
            int newIndex = s.indexOf(b, currentIndex);
            if (newIndex == -1 || newIndex > slength - blength)
                break;
            bIndecies.add(newIndex);
            if(indexB != -1)
                currentIndex = newIndex + indexB;
            else {
                for(int i = 1; i < blength; i++){
                    if (newIndex + i > slength - blength)
                        break;
                    bIndecies.add(newIndex + i);
                }
                currentIndex = newIndex + blength;
            }
        }
        List<Integer> result = new ArrayList();
        for(int i = 0, j = 0; i < aIndecies.size(); ++i){
            while(j < bIndecies.size() && aIndecies.get(i) > bIndecies.get(j) && Math.abs(aIndecies.get(i) - bIndecies.get(j)) > k) j++;
            if(j < bIndecies.size() && Math.abs(aIndecies.get(i) - bIndecies.get(j)) <= k) result.add(aIndecies.get(i));
        }

        return result;
    }

     int checkString(String a){
        for(int i = 1; i <= a.length()/2; i++){
            if(a.charAt(i-1) != a.charAt(a.length()-i)) return i;
        }
        if (a.length() % 2 == 1 && a.charAt(a.length()/2) != a.charAt(0)) return a.length()/2;
        return -1;
    }
}
