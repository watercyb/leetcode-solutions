/*
 * Problem: 3263. Convert Doubly Linked List to Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-doubly-linked-list-to-array-i/
 * Language: java
 * Date: 2026-05-05
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node head) {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[] res = new int[count];
        node = head;
        for (int i = 0; i < count; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
