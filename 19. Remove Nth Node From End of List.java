//Given the head of a linked list, remove the nth node from the end of the list and return its head.

//SOLUTION:

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
    ListNode slow = head;
    ListNode fast = head;

    while (n-- > 0)
      fast = fast.next;
    if (fast == null)
      return head.next;

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;

    return head;
  }
}

//the provided Java solution uses two pointers, slow and fast, to remove the nth node from the end of a linked list. 
//It first moves the fast pointer n nodes ahead, handles the case where the head needs to be removed, and then moves both pointers until the end. 
//Finally, it removes the nth node by updating the next pointer of the slow pointer and returns the updated head.
