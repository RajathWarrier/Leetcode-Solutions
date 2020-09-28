/**
 * 2 Pointers - Fast pointer and slow pointer. Fast pointer traverse the entire linked list. Slow pointer updates itself to half of fast pointer
 * during each iteration.
 * Time Complexity - O(N)
 * Spave Complexity - O(1)
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        int slowPtr = 0;
        int fastPtr = 0;
        ListNode middleNode = head;
        
        while(head != null) {
            fastPtr++;
            head = head.next;
            if(slowPtr != fastPtr / 2) {
                slowPtr++;
                middleNode = middleNode.next;
            }
        }
        return middleNode;
    }
}