//Given the head of a linked list, rotate the list to the right by k places.

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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null)
        {
            return head;
        }
        int length=1;
        ListNode curr=head;
        while(curr.next!=null)
        {
            curr=curr.next;
            length++;
        }
        k%=length;
        if(k==0)
        {
            return head;
        }
        curr.next=head;
        // curr=head;
        for(int i=0;i<length-k;i++)
        {
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}
