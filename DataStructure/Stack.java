package DataStructure;
import java.util.Scanner;
class stack {
    private class Node{
        Integer data;
        Node next;
    
        Node(Integer data) {
            this.data = data;
            next = null;
        }
    }
    Node head,top;
    Integer size;

    stack(){
        head = top = null;
        size = 0;
    }

    void push(Integer val){
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        
        top = newNode;
        size++;
    }

    void peek(){
        System.out.println(top.data);
    }

    void pop(){
        if (head == null) {
            System.out.println("THE STACK IS EMPTY");
        } else {
            Node temp = head;
            while(temp.next != top){
                temp = temp.next;
            }
            System.out.println("THE POPPED ELEMENT IS : "+top.data);
            temp.next = null;
            top = temp;
        }
        size--;
    }

    Boolean find(Integer val) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == val)
                return true;

            temp = temp.next;
        }

        return false;
    }

    void reverse() {
        Node next = null;
        Node prev = null;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        top = head;
        head = prev;
    }

    void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Nothing to display");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        stack stk = new stack();
        Scanner s = new Scanner(System.in);
        Integer choice = 0,input;
        do{
            System.out.println("1.PUSH   2.POP   3.FIND   4.DISPLAY   5.REVERSE   6.PEEK   7.EXIT");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.println("ENTER THE NUMBER TO BE INSERTED");
                    input = s.nextInt();
                    stk.push(input);
                    System.out.println("THE ELEMENT HAS BEEN INSERTED");
                    break;
                case 2:
                    stk.pop();
                    break;
                case 3:
                    System.out.println("ENTER THE NUMBER TO FIND");
                    input = s.nextInt();
                    if(stk.find(input)){
                        System.out.println("THE ELEMENT IS PRESENT IN THE STACK");
                    }
                    else{
                        System.out.println("THE ELEMENT IS NOT PRESENT IN THE STACK");
                    }
                    break;
                case 4:
                    System.out.println("THE ELEMENTS ARE:");
                    stk.display();
                    System.out.println();
                    break;
                case 5:
                    stk.reverse();
                    stk.display();
                    System.out.println();
                    break;
                case 6:
                    stk.peek();
                    break;
                case 7:
                    break;
            }
        }
        while(choice != 7);
        s.close();
    }
}
