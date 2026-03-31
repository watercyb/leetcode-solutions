/*
 * Problem: 3885. Design Event Manager
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-event-manager/
 * Language: kotlin
 * Date: 2026-03-31
 */

class EventManager(events: Array<IntArray>) {
    val PQ = PriorityQueue<IntArray>{a,b->if (a[1] == b[1]) a[0] - b[0] else b[1] - a[1]}
    val HM = HashMap<Int,Int>()

    init {
        for (arr in events) {
            PQ.offer(arr)
            HM.put(arr[0], arr[1])
        }
    }

    fun updatePriority(eventId: Int, newPriority: Int) {
        PQ.offer(intArrayOf(eventId, newPriority))
        HM.put(eventId,newPriority)
    }

    fun pollHighest(): Int {
        while (!PQ.isEmpty()&&HM.get(PQ.peek()[0])!=PQ.peek()[1]) {
            PQ.poll()
        }
        if (PQ.isEmpty()) return -1
        val pair=PQ.poll()
        HM.remove(pair[0])
        return pair[0]
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * var obj = EventManager(events)
 * obj.updatePriority(eventId,newPriority)
 * var param_2 = obj.pollHighest()
 */
