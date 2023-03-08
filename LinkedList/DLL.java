package LinkedList;

public class DLL {
    Node head;
    Node tail;

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    
    public  void insertFirst(int value) {
            Node node = new Node(value);
            node.next = head;
            node.prev = null;
            if( head != null) head.prev = node;         
            head = node;
    }

    public void insertLast(int value) {
       Node node = new Node(value);
       if( head == null )  insertFirst(value); 
       else {
       Node last = head;
       while(last.next != null) {
          last = last.next;
       }

       last.next = node;
       node.prev = last;
       node.next = null;
    }
    }
   

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print( temp.value + " <-> "  );
            temp = temp.next;
        }

        System.out.println( "END"  );
    }

    public Node find( int value ) {
        Node temp = head;
        if( temp == null ) return null;
        while( temp != null) {
            if( temp.value == value){ 
            return temp;
            }
            temp = temp.next;
        }
         return null;
    }

    public void insertAfter( int after, int value ) {
           Node p = find(after);
           if( p == null) return;
        //     22   10
           Node node = new Node(value);
           node.next = p.next;
           node.prev = p;
           p.next = node;
           if(node.next != null ) node.next.prev = node;
    }

    public Node getTail() {
        Node tail = head;
        Node temp = head;
        while(temp != null) {
            tail = temp;
            temp = temp.next;
        }
        return tail;
    }

    public void displayRev() {
        Node temp = tail;
        while(temp != null) {
            System.out.print( temp.value + " <-> "  );
            temp = temp.prev;
        }

        System.out.println( "START"  );
    }


    public static void main(String[] args) {
        DLL l = new DLL();
        l.insertLast(22);
         l.insertLast(33);
      
         l.insertAfter(33, 10);
         
        l.display();
    }
}
