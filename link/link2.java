// detect and remove loop
Node removeLoop(Node node){
    if(node==null) return;
    Node slow = node;
    Node fast = node;

    while(slow!=null && fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow==fast){
            break;
        }
    }

    if(slow == fast){
        slow = node;

        if(slow!=fast){
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }

            // found meeting point
            fast.next = null;
        }

        else{
            while(fast.next!=slow){
                fast = fast.next;
            }
            fast.next = null;
        }
        
    }
}