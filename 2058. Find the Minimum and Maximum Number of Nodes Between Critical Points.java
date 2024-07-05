//A critical point in a linked list is defined as either a local maxima or a local minima.
//A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
//A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
//Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
//Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. 
//If there are fewer than two critical points, return [-1, -1].

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCPI=-1;
        int prevCPI=-1;
        int currentIndex=1;
        ListNode cur = head.next;
        ListNode prev = head;
        int res[] = new int [2];
        res[0]= Integer.MAX_VALUE;
        while(cur.next!=null){
            ListNode nextNode = cur.next;
            if((cur.val < nextNode.val && cur.val < prev.val) || 
            (cur.val > nextNode.val && cur.val > prev.val)){
                if(prevCPI==-1){
                    firstCPI = currentIndex;
                    prevCPI =currentIndex;
                }
                else{
                    res[0]=Math.min(res[0], currentIndex-prevCPI);
                    prevCPI= currentIndex;
                }
            }
            prev = prev.next;
            cur = cur.next;
            currentIndex++;
        }
        if (firstCPI!=-1 && res[0]!= Integer.MAX_VALUE){
            res[1] = prevCPI - firstCPI;
        } else{
            res[0] = -1;
            res [1] = -1;
        }
        return res;
    }
}
