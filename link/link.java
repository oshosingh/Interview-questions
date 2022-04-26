public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 // Reverse a linked list
 public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
}

// Reverse linked list between location l & r
public ListNode reverseBetween(ListNode head, int l, int r) {
        ListNode dummy = new ListNode(0, head);
        ListNode lp = dummy;
        ListNode cur = head;
        
        for(int i=0; i<l-1; i++){
            lp = cur;
            cur = cur.next;
        }
        
        ListNode prev = null; 
        for(int i=0; i<r-l+1; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        lp.next.next = cur;
        lp.next = prev;
        
        return dummy.next;
 }

 // Rotate linked list by K places
 public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || k==0) return head;
        ListNode fast=head;
        int count=1;
        //Reach to the end and connect it with the head making the loop also count the length
         while(fast.next!=null){
            fast=fast.next;
             count++;
        }
        fast.next=head;//end connected with head
        k%=count;//total number of effective rotations
        for(int i=0; i<count-k;i++){
            fast=fast.next;
        }
        //now reach to the node and point it to null
        ListNode ans=fast.next; //store the ans before marking it as null
        fast.next=null;
        return ans;   
 }
 
 // Rverse linked list in groups of size K, if group size is less than K don't reverse that group
 public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        
        boolean hasNode = true;
        ListNode temp = head;
        int x = k;
        
        while(temp != null && x>0){
            temp = temp.next;
            x--;
        }
        
        if(x>0){
            hasNode = false;
        }
        
        if(hasNode){
            ListNode prev = null;
            ListNode cur = head;
            ListNode next = null;
            int count = 0;
            
            while(count<k && cur != null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            
            if(cur != null){
                head.next = reverseKGroup(next, k);
            }
            
            head = prev;
        }

        return head;
    }

// swap in pairs of two
ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        
        if(head.next == null){
            return head;
        }
        
        ListNode current = head;
        ListNode temp = head.next;
        ListNode next = null;
        
        next = current.next;
        current.next = swapPairs(next.next);
        next.next = current;
        
        return temp;
}

// remove nth node from end of list
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        
        while(cur != null){
            count++;
            cur = cur.next;
        }
        
        int x = count-n+1;
        if(x==1){
            return head.next;
        }
        
        ListNode prev = null;
        cur = head;
        int u = 0;
        while(cur != null){
            u++;
            if(u==x){
                prev.next = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
        
        return head;
}
