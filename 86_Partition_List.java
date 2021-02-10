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
/**Time Complexity - O(n)
 * Space Complexity - O(n)
 * 
 * Approach - Build 2 LLs separately, by adding to the tail. One will grow by adding elements less than the partition value
 * and the other one will grow by adding elements greater than or equal to the partition value. Join the two LLs to form
 * the resultant LL.
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode();
        ListNode sPtr = smaller;
        
        ListNode greater = new ListNode();
        ListNode gPtr = greater;
        
        ListNode ptr = head;
        while(ptr != null) {
            if(ptr.val < x) {
                sPtr.next = new ListNode(ptr.val);
                sPtr = sPtr.next;
            }
            else {
                gPtr.next = new ListNode(ptr.val);
                gPtr = gPtr.next;
            }
            ptr = ptr.next;
        }
        smaller = smaller.next;
        greater = greater.next;
        
        if(greater == null)
            return smaller;
        if(smaller == null)
            return greater;
        sPtr.next = greater;
        return smaller;
    }
}