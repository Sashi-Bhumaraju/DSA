package LinkedList;


public class LL {

    Node head ;
    int size = 0;
    class Node {
        int value;
        Node next;

        Node ( int value) {
             this.value = value;
             this.next = null;
        }
    }
   
    public void display() {
        Node temp = head;
        while( temp != null) {
            System.out .print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void inserFirst(int value ) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public Node getLastNode () {
        Node temp = head;
        if(temp == null) return temp;
        while ( temp.next != null ) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertLast( int value ) {
        if( head == null ){ inserFirst(value);    return; } 
        Node last = getLastNode();
        Node node = new Node(value);
        last.next = node;
        size++;
    }

    public void deleteFirst() {
        if(head == null) return;
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if(head == null) return;
        if(head.next == null) {head = null; return;}
        Node last = head;
        Node temp = head.next;
        while( temp.next != null) {
              last = temp;
              temp = temp.next;
        }
        last.next = null;
        size--;
    }

     public void insert(int index,int value) {
        if(index >= size) return;
        else if(index == 0) inserFirst(value);
        else if(index == size-1) insertLast(value);
        else {
            Node temp = head;
            int i = 0;
            while(temp.next != null) {
                if(i == index-1){
                     break;}
                i += 1;
                temp = temp.next;

            }
          Node node = new Node(value);
          node.next = temp.next;
          temp.next = node;
        }
        
     }

     public void insertAfter( int after, int value) {
        if( head == null ) return;
        Node temp = head;
        while ( temp != null) {
            if( temp.value == after )  {
                  Node node = new Node(value);
                  node.next = temp.next;
                  temp.next = node;
                  break;
            }
            temp = temp.next;
        } 
     }

     public void insertBefore( int before, int value) {
        if(head == null ) return ;
        Node node = new Node(value);
        if(head.value == before) { node.next = head; head = node; return; }
        Node temp = head.next;
        Node prev = head;
        while( temp != null) {
            if(temp.value == before) {
                 node.next = prev.next;
                 prev.next = node;
            }
            prev = temp;
            temp = temp.next;
        }
     }

    public static void main(String[] args) {
         LL l = new LL();
         l.inserFirst(1);
        //  l.inserFirst(2);
        //  l.inserFirst(3);
        //  l.inserFirst(4);
        //  l.insertLast(10);
        //  l.insertLast(20);
        //  l.insertLast(30);

         
        //  l.display();
        //  l.deleteLast();
        //  l.deleteFirst();
         l.display();
        //  l.insertAfter(1, 66);
         l.insertBefore(1, 200);
         l.display();
        
         System.out.print(l.size);

    }
}