package DataStructure;
import java.util.*;
public class Graph {
    class Node{
        int data;
        ArrayList<Node>adj;
        Node(int data){
            this.data = data;
            adj = new ArrayList<>();
        }
    }
    Node origin;
    HashMap<Node,Boolean>visited = new HashMap<>();
    Graph(){
        origin = null;
    }

    void add(int data){
        if(origin == null){
            Node n = new Node(data);
            origin = n;
            visited.put(origin,false);
        }
    }

    void add(int node,int data){
        if(origin == null){
            add(data);
        }

        Queue<Node> q = new LinkedList<>();

        q.add(origin);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.data == node){
                Node n = new Node(data);
                temp.adj.add(n);
                visited.put(n,false);
                return;
            }

            q.addAll(temp.adj);
        }
        System.out.println("ELEMENT NOT FOUND");
    }
    void edge(int node1,int node2){
        Node n1=null,n2=null;

        Queue<Node> q = new LinkedList<>();

        q.add(origin);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if(temp.data == node1){
                n1 = temp;
            }

            if(temp.data == node2){
                n2 = temp;
            }

            q.addAll(temp.adj);
        }
        if(n1 != null && n2 != null){
            n1.adj.add(n2);
        }
        else if(n1 == null){
            Node newNode = new Node(node1);
            visited.put(newNode,false);
            newNode.adj.add(n2);
        }
        else if(n2 == null){
            Node newNode = new Node(node2);
            visited.put(newNode,false);
            n1.adj.add(newNode);
        }
    }

    void reset(){
        for(var v:visited.keySet()){
            visited.put(v,false);
        }
    }

    void BFS(int originValue){
        Node currentOrigin = null;
        Queue<Node> q = new LinkedList<>();
        q.add(origin);
        visited.put(origin,true);
        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.data == originValue){
                currentOrigin = temp;
                break;
            }

            for(int i=0;i<temp.adj.size();i++){
                if(!visited.get(temp.adj.get(i))){
                    visited.put(temp.adj.get(i),true);
                    q.add(temp.adj.get(i));
                }
            }
        }
        if(currentOrigin == null) return;

        q.clear();
        reset();
        q.add(currentOrigin);
        visited.put(currentOrigin,true);
        while (!q.isEmpty()) {
            Node temp = q.poll();

            System.out.print(temp.data+" ");

            for(int i=0;i<temp.adj.size();i++){
                if(!visited.get(temp.adj.get(i))){
                    visited.put(temp.adj.get(i),true);
                    q.add(temp.adj.get(i));
                }
            }
        }
    }

    void DFS(int originValue){
        Node currentOrigin = null;
        Queue<Node> q = new LinkedList<>();
        q.add(origin);
        visited.put(origin,true);
        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.data == originValue){
                currentOrigin = temp;
                break;
            }
            
            for(int i=0;i<temp.adj.size();i++){
                if(!visited.get(temp.adj.get(i))){
                    visited.put(temp.adj.get(i),true);
                    q.add(temp.adj.get(i));
                }
            }
        }
        if(currentOrigin == null) return;
        reset();
        Stack<Node> stk = new Stack<>();
        System.out.println(currentOrigin.data);
        stk.push(currentOrigin);
        while(!stk.isEmpty()){
            Node temp = stk.pop();

            System.out.print(temp.data+" ");

            for(int i=0;i<temp.adj.size();i++){
                if(!visited.get(temp.adj.get(i))){
                    visited.put(temp.adj.get(i),true);
                    stk.push(temp.adj.get(i));
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER THE VALUE OF THE FIRST NODE:");
        int n = s.nextInt();
        g.add(n);
        int input = 0,choice = 0;
        do{
            System.out.println("1.INSERT   2.BFS   3.DFS   4.EXIT");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.println("ENTER THE EDGES TO BE CONNECTED");
                    g.add(s.nextInt(),s.nextInt());
                    break;
                case 2:
                    System.out.println("ENTER THE ORIGIN");
                    input = s.nextInt();
                    g.BFS(input);
                    System.out.println();
                    g.reset();
                    break;
                case 3:
                    System.out.println("ENTER THE ORIGIN");
                    input = s.nextInt();
                    g.DFS(input);
                    System.out.println();
                    g.reset();
                    break;
                case 4:
                    break;
            }
        }
        while(choice != 4);

        s.close();
    }
}