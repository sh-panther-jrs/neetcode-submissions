/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeCount = getCount(head);
        if(nodeCount==0 || nodeCount<n) {
            return head;
        }
        if (nodeCount==n) {
            return head.next;
        }
        ListNode prev= null;
        ListNode curr = head;
        int nodeFromStart = nodeCount-n;
    
        while(nodeFromStart>0) {
            prev=curr;
            curr = curr.next;
            nodeFromStart--;
        }
        if (curr!=null) {
            prev.next = curr.next;
        }
        
        return head;
    }

    private int getCount(ListNode head) {
        int count =0;
        ListNode curr= head;
        while(curr!=null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
