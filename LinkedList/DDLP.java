package LinkedList;

// Feel free to add new properties and methods to the class.
public class DDLP {

  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      // Write your code here.
      remove(node);
      node.next = head;
      node.prev = null;
      if(head != null){ head.prev = node;} else { tail = node;}
      head = node;
      
      
    }

    public void setTail(Node node) {
      // Write your code here.
      node.prev = tail;
      node.next = null;
      if( tail != null) { tail.next = node; } else { head = node; }
      tail = node;
    }

   

    public void insertBefore(Node node, Node nodeToInsert) {
      // Write your code here.
      if( head == null ) return;
      remove(nodeToInsert);
      if( node.value == head.value ) {setHead(nodeToInsert); return; }
      Node temp = head;
      while ( temp != null ) {
          if( temp.value == node.value ) {
            nodeToInsert.next = temp;
            nodeToInsert.prev = temp.prev;
            nodeToInsert.prev.next = nodeToInsert;
            temp.prev = nodeToInsert;
            return;
            
          }
          temp = temp.next;
      }
      
      return;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      // Write your code here.
      if( head == null ) return;
      Node temp = head;
      while ( temp != null ) {
        if( temp.value == node.value ) {
             nodeToInsert.next = temp.next;
             nodeToInsert.prev = temp;
             
             temp.next = nodeToInsert;
             if( nodeToInsert.next != null ) { nodeToInsert.next.prev = nodeToInsert; remove(head); } 
             else { tail = nodeToInsert;}
             return;
        }
        temp = temp.next;
      }
    }

    
    public void insertHead(Node node) {
        // Write your code here.
       
        node.next = head;
        node.prev = null;
        if(head != null){ head.prev = node;} else { tail = node;}
        head = node;
        
        
      }
    public void insertAtPosition(int position, Node nodeToInsert) {
      // Write your code here.
      if(head == null ) return;
      if( position == 1 ) { insertHead(nodeToInsert); return; }

      Node temp = head.next;
      int i = 2;
      while( temp != null ) {
        System.out.println(i);
        if( i == position) {
             nodeToInsert.next = temp;
             nodeToInsert.prev = temp.prev;
             nodeToInsert.prev.next = nodeToInsert;
            return;
        }
        i++;
        temp = temp.next;
      }
      
    }

    public void removeFirst() {
        if( head == null) return;
        head = head.next;
        if(head != null)  head.prev = null; else { tail = null; }
    }

    public void removeLast(){
        if (tail == null) return;
        tail = tail.prev;
        if( tail != null ) tail.next = null; else  { head = null;}
    }

    public void removeNodesWithValue(int value) {
      // Write your code here.
      if( head == null) return;
      Node temp = head;
      while( temp != null ) {
        if( temp.value == value ) {
             if( head == temp ) removeFirst();
            else if( tail == temp ) removeLast();
               else {
                       temp.prev.next = temp.next;
                       temp.next.prev = temp.prev;
               }
        }
        temp = temp.next;
      }
      
      
      
    }

    public void remove(Node node) {
      // Write your code here.
      if( head == null) return;
      Node temp = head;
      while( temp != null ) {
        if( temp.value == node.value ) {
             if( head == temp ) removeFirst();
            else if( tail == temp ) removeLast();
               else {
                       temp.prev.next = temp.next;
                       temp.next.prev = temp.prev;
               }
        }
        temp = temp.next;
      }
      
        }
        
    

    public boolean containsNodeWithValue(int value) {
      // Write your code here.
      Node temp = head;
      while ( temp != null ) {
        if(temp.value == value) return true;
          temp = temp.next;
      }
      return false;
    }
    public void display() {
           Node temp = head;
           while(temp != null) {
             System.out.print(temp.value + " -> ");
             temp = temp.next;
           }
           System.out.println();
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public static Node cNode(int value) {
      return new Node(value);
  }
  public static void main(String[] args) {
    DoublyLinkedList l = new DoublyLinkedList();
    Node node = new Node(10);
    // l.setTail(cNode(20));
   
    l.setHead(cNode(1));
     l.setTail(cNode(2));
      l.setTail(cNode(3));
      l.setTail(cNode(4));
      l.setTail(cNode(5));
    
l.setHead(cNode(4));
l.setTail(cNode(6));
l.display();
l.insertBefore(cNode(6), cNode(3));
l.insertAfter(cNode(6), cNode(3));
l.insertAtPosition(1, cNode(3));
l.removeNodesWithValue(3);
l.remove(cNode(2));
boolean v =  l.containsNodeWithValue(5);
System.out.print(v);
    l.display();
    
  
    // l.insertAtPosition(6, cNode(1));

    // l.display();
System.out.print( l.tail.value);
System.out.print(l.head.value );

    
  }
}

