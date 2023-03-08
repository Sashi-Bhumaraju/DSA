import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {
    
   static class Node {
        int value;
        Node left ;
        Node right ;
        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static Node insertNode(Node root, int value){
        if(root == null) {
            root = new Node(value);
            return root;
        }
        if(value < root.value) {
             root.left = insertNode(root.left, value);
        }
        if( value > root.value){
            root.right = insertNode(root.right, value);
        }
        return root;
    }

  static  void takeInput (Node root) {

        System.out.println("Start entering data for BST");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        
        while( value != -1 ) {
             insertNode(root, value);
            value = sc.nextInt();
        }
    }

    static void preorder(Node root) {
        if(root == null) return ;
        preorder(root.left);
        System.out.println(root.value+" ");
        preorder(root.right);
    }

    static void levelorder(Node root) {
        if( root == null) return;
        List<Node>  q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node temp = q.remove(0);
            if( temp == null ) {
                if(q.isEmpty()) break;
                q.add(null);
                System.out.println();
            } else {
            System.out.print(temp.value+" ");
            if( temp.left != null)
            q.add(temp.left);
            if(temp.right != null)
            q.add(temp.right);
            }
        }
    }

    public static void delete(Node root, int target) {
          
        
    }

    public static void main(String[] args) {
        Node root = null;
        takeInput(root);
        preorder(root);
        levelorder(root);
    }
}
