package DataStructure;
import java.util.*;
public class BST {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    Node add(int data, Node root) {
        if (root == null) {
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }

        if (data > root.data) {
            root.right = add(data, root.right);
        } else {
            root.left = add(data, root.left);
        }

        return root;
    }

    void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    boolean search(int val,Node root){
        if(root != null){
            if(root.data == val)return true;

            if(root.data > val){
                return search(val,root.left);
            }
            return search(val,root.right);
        }
        return false;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner s = new Scanner(System.in);
        int choice = 0,input = 0;
        do{
            System.out.println("1.INSERT   2.SEARCH   3.DISPLAY   4.EXIT");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.println("ENTER THE ELEMENT TO BE INSERTED:");
                    input = s.nextInt();
                    tree.root = tree.add(input,tree.root);
                    break;
                case 2:
                    System.out.println("ENTER THE ELEMENT TO BE SEARCHED");
                    input = s.nextInt();
                    System.out.println(tree.search(input,tree.root));
                    break;
                case 3:
                    tree.inOrder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    break;
            }
        }
        while(choice != 4);
        s.close();
    }
}
