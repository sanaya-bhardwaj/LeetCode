//You are given the head of a linked list.
//Remove every node which has a node with a greater value anywhere to the right side of it.
//Return the head of the modified linked list.

class Solution {
  public ListNode removeNodes(ListNode head) {
    if (head == null)
      return null;
    head.next = removeNodes(head.next);
    return head.next != null && head.val < head.next.val ? head.next : head;
  }
}
