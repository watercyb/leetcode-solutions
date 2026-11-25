/*
 * Problem: 4122. Earliest Signal Activation Times
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/earliest-signal-activation-times/
 * Language: kotlin
 * Date: 2026-11-25
 */

class Solution {
    fun earliestActivationTimes(n: Int, edges: Array<IntArray>, requiredSignals: IntArray): LongArray {
        val pq = PriorityQueue<LongArray>(compareBy { it[0] })
        val links = Array(n) {  mutableListOf<IntArray>() }
        for (edge in edges) {
            links[edge[0]].add(intArrayOf(edge[1], edge[2]))
        }
        val res=LongArray(n){-1}
        pq.offer(longArrayOf(0,0))
        requiredSignals[0]=1
        while (!pq.isEmpty()) {
            val current=pq.poll()
            val idx=current[1].toInt()
            val t=current[0]
            requiredSignals[idx]--
            if (requiredSignals[idx]==0) {
                res[idx]=t
                for (next in links[idx]) {
                    val nextIdx=next[0]
                    val nextTime=t+next[1]
                    if (requiredSignals[nextIdx]>0) {
                        pq.offer(longArrayOf(nextTime, nextIdx.toLong()))
                    }
                }
            }
        }
        return res;
    }
}
