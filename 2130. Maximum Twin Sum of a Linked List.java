//In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
//For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. 
//These are the only nodes with twins for n = 4.
//The twin sum is defined as the sum of a node and its twin.
//Given the head of a linked list with even length, return the maximum twin sum of the linked list.

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
    public ListNode reverselist(ListNode head){
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
        ListNode next=current.next;
        current.next=prev;
         prev=current;
         current=next;

    }
      return prev;
}
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
      
        ListNode j=reverselist(slow);
       
        ListNode i=head;
        int sum=Integer.MIN_VALUE;
        while(j!=null){
            sum=Math.max(i.val+j.val,sum);
            i=i.next;
            j=j.next;
        }
        return sum;
    }
}
