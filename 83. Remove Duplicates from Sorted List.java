class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode temp = head.next;
        ListNode ptr = head;
        
        while(temp != null) {
            if(ptr.val != temp.val){
                ptr.next = temp;
                ptr = temp;
            }
            
            temp = temp.next;
        }
        
        ptr.next = null;
        
        return head;
    }
}
