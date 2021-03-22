package interviewQuestions;

import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class copyListWithRandomPointer {
    HashMap<Node,Node> Map = new HashMap<>();
public Node getCopy(Node node)
{
    if(node==null)
        return null;
      
    Node newNode=new Node(node.val);
    newNode.next=getCopy(node.next);
        Map.put(node,newNode);
    return newNode;
}

public Node copyRandomList(Node head) {
    
    Node newHead=getCopy(head);
    
    for(Node key:Map.keySet())
    {
        Node copy=Map.get(key);
        copy.random=Map.get(key.random);
    }
    
    return newHead;
    
    }
}
