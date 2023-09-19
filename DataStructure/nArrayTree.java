package DataStructure;

import java.util.*;

public class nArrayTree {
    class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            children = new ArrayList<>();
        }
    }

    Node root;
    int n;

    void add(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.children.size() < n) {
                temp.children.add(newNode);
                return;
            } else {
                q.addAll(temp.children);
            }
        }
    }

    boolean delete(int val) {
        if (root.data == val) {
            if (root.children.isEmpty()) {
                root = null;
            } else {
                Node temp = root.children.get(0);
                root.children.remove(0);
                if (root.children.isEmpty()) {
                    root = temp;
                    return true;
                }

                temp.children.addAll(root.children);
                root = temp;
            }
            return true;

        } else {
            Queue<Node> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {
                Node temp = q.poll();
                boolean contains = false;
                int containsPosition = 0;
                for (int i = 0; i < temp.children.size(); i++) {
                    if (temp.children.get(i).data == val) {
                        contains = true;
                        containsPosition = i;
                        break;
                    }
                }

                if (temp.children.get(containsPosition).children.isEmpty()){
                    temp.children.remove(containsPosition);
                    return true;
                }

                if (contains) {
                    Node tempNode = temp.children.get(containsPosition);
                    temp.children.add(tempNode.children.get(0));
                    tempNode.children.remove(0);
                    temp.children.get(temp.children.size()-1).children.addAll(tempNode.children);
                    temp.children.remove(containsPosition);
                    return true;
                }

                q.addAll(temp.children);
            }
        }
        return false;
    }

    int height() {
        int height = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {
                height++;

                if (!q.isEmpty()) {
                    q.add(null);
                }

                continue;
            }

            q.addAll(temp.children);
        }

        return height;
    }

    void BFS() {
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            System.out.print(temp.data + " ");

            q.addAll(temp.children);
        }
    }

    void DFS() {
        Stack<Node> stk = new Stack<>();

        stk.add(root);

        while (!stk.isEmpty()) {
            Node temp = stk.pop();

            System.out.print(temp.data + " ");
            LinkedList<Node> tempList = new LinkedList<>();
            tempList.addAll(temp.children);
            Collections.reverse(tempList);
            stk.addAll(tempList);
        }
    }

    public static void main(String[] args) {
        nArrayTree tree = new nArrayTree();
        Scanner s = new Scanner(System.in);

        System.out.println("ENTER THE VALUE FOR N");
        tree.n = s.nextInt();

        int choice = 0, input = 0;

        do {
            System.out.println("1.INSERT   2.DELETE   3.BFS   4.DFS   5.FIND_HEIGHT   6.EXIT");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("ENTER THE ELEMENT TO BE INSERTED");
                    input = s.nextInt();
                    tree.add(input);
                    System.out.println("THE ENTERED ELEMENT HAS BEEN INSERTED");
                    break;
                case 2:
                    System.out.println("ENTER THE ELEMENT TO BE DELETED");
                    input = s.nextInt();
                    if (tree.delete(input)) {
                        System.out.println("THE ELEMENT HAS BEEN DELETED");
                    } else {
                        System.out.println("THE ENTERED ELEMENT IS NOT PRESENT IN THE TREE.");
                    }
                    break;
                case 3:
                    System.out.println("BFS:");
                    tree.BFS();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("DFS:");
                    tree.DFS();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("THE HEIGHT OF THE TREE IS " + tree.height());
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);

        s.close();
    }
}