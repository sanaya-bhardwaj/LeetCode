//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
//Return the linked list sorted as well.

//Solution:

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
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;

    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val)
        curr.next = curr.next.next;
      curr = curr.next;
    }

    return head;
  }
}

//curr is a pointer used to traverse the linked list.
//The outer loop (while (curr != null)) iterates through the entire linked list.
//The inner loop (while (curr.next != null && curr.val == curr.next.val)) skips consecutive duplicate nodes.
//The curr = curr.next; statement moves the pointer to the next distinct node.
//Finally, it returns the modified head of the linked list.
//This implementation efficiently removes duplicates in a sorted linked list and has a time complexity of O(n), where n is the number of nodes in the list.





