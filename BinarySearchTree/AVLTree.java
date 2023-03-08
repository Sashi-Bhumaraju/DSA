import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AVLTree {

    public static class Node {
        int value;
        int height;
        Node left;
        Node right;

        Node(int value ) {
            this.value = value;
            this.height = 1;
        }
    }

    public static int getHeight(Node node) {
      if(node == null) return 0;
      return node.height;
    }

    public static int getBalance(Node node) {
        if(node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public static Node rightRotate(Node root) {
           Node y = root.left;
           Node yr = y.right;
           y.right = root;
           root.left = yr;
           root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
           y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
           return y; 
    }

    public static Node leftRotate(Node root) {
        Node y = root.right;
        Node yl = y.left;
        y.left = root;
        root.right = yl;
        root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        return y;
    }

    public static Node insert(Node root, int value) {
       if(root == null ) return new Node(value);
       if( value < root.value ) root.left = insert(root.left, value);
       if( value >= root.value ) root.right = insert(root.right, value);
       root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;
       int balance = getBalance(root);
       if(balance > 1 && value < root.left.value) {
            return rightRotate(root);
       }
       else if (balance < -1 && value > root.right.value) {
            return leftRotate(root);
       }
       else if( balance > 1 && value > root.left.value ) {
                 root.left = leftRotate(root.left);
                 return rightRotate(root);
       } else if( balance < -1 && value < root.right.value) {
           root.right = rightRotate(root.right);
           return leftRotate(root);
       }
       return root;
    }

    public static void inorder(Node root) {
        if( root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        int v =  sc.nextInt();
        while( v != -1) {
          root = insert(root, v);
            v =  sc.nextInt();
        }
        levelorder(root);

    }
}
