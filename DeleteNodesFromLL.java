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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> delete = new HashSet<>();
        for(int n : nums){
            delete.add(n);
        }
        ListNode temp = new ListNode(0,head);
        ListNode curr = temp;
        while(curr.next!=null){
            if(delete.contains(curr.next.val)){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }
        return temp.next;
    }
}