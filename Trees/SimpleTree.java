package Trees;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class SimpleTree {
  public  class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;

        }
    }

    public  Node buildTree() {
           System.out.println("Enter value:");
           Scanner sc = new Scanner(System.in);
           int value = sc.nextInt();
           if( value == -1) return null;
           Node root =new Node(value);
           System.out.println("Enter value left:");
           root.left = buildTree();
           System.out.println("Enter value right:");
           root.right = buildTree();
           return root;
    }

    public void levelOrder(Node root) {
        LinkedList<Node> q = new LinkedList<Node>();
        Stack<Node> s = new Stack<Node>();
        q.add(root);
        q.add(null);
         System.out.println("\n");
        while(!q.isEmpty()) {
            Node temp = q.getFirst();
            q.remove();
         if( temp == null ) {
            System.out.println();
            s.push(null);
            if(!q.isEmpty()) q.add(null);
         } else {
            System.out.print(temp.value);
            s.push(temp);
            if( temp.left != null) {
                q.add(temp.left);
            }
            if( temp.right != null ){
                q.add( temp.right );
            }}
        }

        while(!s.isEmpty()) {
            Node temp = s.pop();
            if(temp == null) { System.out.println(); continue;}
            System.out.print(temp.value);
        }
    }


    public void inorder(Node root) {
        if( root == null ) return;
        inorder(root.left);
        System.out.print(root.value);
        inorder(root.right);
    }

    public void inorderIteration(Node root){
        if( root == null) return;
        Node temp = root;
        Stack<Node> s = new Stack<Node>();
        // s.push(root);

        while( true ) {
             if( temp != null) {
                s.push(temp);
                temp = temp.left;
             } else {
                if(s.isEmpty()) break;
                temp = s.pop();
                System.out.print(" "+ temp.value + " ");
                temp = temp.right;
             }
        }
    }


    public void postorder(Node root){
        if( root == null ) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value);
    }

    

    public void preorder(Node root){
        if( root == null ) return;
        System.out.print(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    public void preorderIteration( Node root ) {
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while( !s.isEmpty() ) {
            Node temp = s.pop();
            System.out.print(" "+ temp.value+" ");
            if( temp.right != null) s.push(temp.right);
            if( temp.left != null) s.push(temp.left);
        }
    }
   
    public static void main(String[] args) {
        SimpleTree tree = new SimpleTree();
       Node root =  tree.buildTree();
    //    tree.levelOrder(root);
       tree.inorder(root);
    //    tree.preorder(root);
    //    tree.postorder(root);
    //    tree.inorderIteration(root);
       tree.preorderIteration(root);
    }
}
