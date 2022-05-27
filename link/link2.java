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

// Copy List with random pointer (SNow)
public Node copyRandomList(Node head) {
    Map<Node, Node> oldToNew = new HashMap<>();
    oldToNew.put(null, null);
        
    Node curr = head;
        
    // Create copies map in first pass
    while(curr != null){
        Node copy = new Node(curr.val);
        oldToNew.put(curr, copy);
        curr = curr.next;
    }
        
    curr = head;
        
    // second iteration to update the pointers
    while(curr != null){
        Node copy = oldToNew.get(curr);
        copy.next = oldToNew.get(curr.next);
        copy.random = oldToNew.get(curr.random);
            
        curr = curr.next;
    }
        
    return oldToNew.get(head);    
}