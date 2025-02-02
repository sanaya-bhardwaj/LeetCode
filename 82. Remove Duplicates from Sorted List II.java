//Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
//Return the linked list sorted as well.

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(1000, head); // Dummy node to handle edge cases
        ListNode cur = ans; 

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) { // Check if duplicates exist
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) { // Skip all duplicates
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next; // Move to the next node
            }
        }

        return ans.next; // Return the modified list starting after the dummy node
    }
}
