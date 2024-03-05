//You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//Return the head of the merged linked list.

//SOLUTION:
class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // Base case: If either list is null, return the other list
    if (list1 == null || list2 == null)
      return list1 == null ? list2 : list1;

    // Swap lists if the first node of list1 has a greater value than the first node of list2
    if (list1.val > list2.val) {
      ListNode temp = list1;
      list1 = list2;
      list2 = temp;
    }

    // Recursively merge the remaining lists
    list1.next = mergeTwoLists(list1.next, list2);

    // Return the head of the merged list
    return list1;
  }
}

//The base case checks if either of the lists is null. If one list is null, it returns the other list. 
//If both are null, it returns null, indicating the end of the merge process.
//If the first node of list1 has a greater value than the first node of list2, it swaps the lists. 
//This ensures that the merged list is always built with the smaller node as the starting point.
//The function then recursively calls itself with the updated list1.next and the original list2. 
//This step continues until one of the lists becomes null, and the base case is reached.
//The modified list1 is returned, representing the head of the merged list.
//This recursive approach is a valid and elegant solution for merging two sorted linked lists.
