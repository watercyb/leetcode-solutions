/*
 * Problem: 39. Combination Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/combination-sum/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,new ArrayList<>(), candidates, target,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> Li, int[] candidates, int target, int i) {
        if (target==0) {
            List<Integer> tmp=new ArrayList<>();
            for (int in:Li) {
                tmp.add(in);
            }
            res.add(tmp);
        } else {
            for (int j=i;j<candidates.length;j++) {
                if (candidates[j]<=target) {
                    Li.add(candidates[j]);
                    dfs(res,Li,candidates,target-candidates[j],j);
                    Li.remove(Li.size()-1);
                }
            }
        }
    }
}
