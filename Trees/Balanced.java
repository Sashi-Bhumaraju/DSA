package Trees;

import java.util.Scanner;

public class Balanced {

    class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node buildTree() {
        System.out.println("enter node data:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        if ( value == -1) return null;
        Node root = new Node(value);
        System.out.format("enter %d left child", value);
        root.left = buildTree();
        System.out.format("enter %d right child", value);
        root.right = buildTree();
        return root;
    }

    void printTree(Node root) {
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.value+" ");
        printTree(root.right);
    }


    public static void main(String[] args) {
        Balanced tree = new Balanced();
        Node root = tree.buildTree();
        tree.printTree(root);
        
    }


}
