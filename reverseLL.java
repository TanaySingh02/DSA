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
    public ListNode reverseList(ListNode head) {
        ListNode first, second, third;
        if(head==null || head.next==null)
        return head;
        
        first=head;
        second=first.next;
        third=second.next;
        first.next=null;
        if(third==null)
        {
            second.next=first;
            head=second;
            return head;
        }
        while(third!=null)
        {
            second.next=first;
            first=second;
            second=third;
            third=third.next;
        }
        second.next=first;
        first=second;
        head=first;
        return head;
    }
}