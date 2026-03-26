/*
 * Problem: 138. Copy List with Random Pointer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 * Language: java
 * Date: 2026-03-26
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return head;
        HashMap<Node,Integer> HMOr =new HashMap <Node, Integer>();
        HashMap<Integer,Node> HMRe =new HashMap <Integer,Node>();
        Node tmpOr=head;
        Node Re=new Node(head.val);
        Node tmpRe=Re;
        int n=0;
        HMOr.put(tmpOr,n);
        HMRe.put(n,tmpRe);
        while (tmpOr.next!=null) {
            tmpRe.next=new Node(tmpOr.next.val);
            n++;
            HMOr.put(tmpOr.next,n);
            HMRe.put(n,tmpRe.next);
            tmpOr=tmpOr.next;
            tmpRe=tmpRe.next;  
        }
        tmpOr=head;
        tmpRe=Re;
        while (tmpOr!=null) {
            tmpRe.random=HMRe.get(HMOr.get(tmpOr.random));
            tmpOr=tmpOr.next;
            tmpRe=tmpRe.next;
        }
        return Re;
    }
}
