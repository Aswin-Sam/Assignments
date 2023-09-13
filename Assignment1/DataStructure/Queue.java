package Assignment1.DataStructure;

import java.util.Scanner;

public class Queue {
    private class Node{
        Integer data;
        Node next;
    
        Node(Integer data) {
            this.data = data;
            next = null;
        }
    }
    Node head;
    Integer size;

    Queue(){
        head = null;
        size = 0;
    }

    void enqueue(Integer val){
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

        size++;
    }

    void dequeue(){
        if (head == null) {
            System.out.println("THE QUEUE IS EMPTY");
        } else {
            System.out.println(head.data);
            head = head.next;
        }
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
        Queue q = new Queue();
        Scanner s = new Scanner(System.in);
        Integer choice = 0,input;
        do{
            System.out.println("1.ENQUEUE   2.DEQUEUE   3.FIND   4.DISPLAY   5.REVERSE   6.EXIT");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.println("ENTER THE NUMBER TO BE INSERTED");
                    input = s.nextInt();
                    q.enqueue(input);
                    System.out.println("THE ELEMENT HAS BEEN INSERTED");
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    System.out.println("ENTER THE NUMBER TO FIND");
                    input = s.nextInt();
                    if(q.find(input)){
                        System.out.println("THE ELEMENT IS PRESENT IN THE QUEUE");
                    }
                    else{
                        System.out.println("THE ELEMENT IS NOT PRESENT IN THE QUEUE");
                    }
                    break;
                case 4:
                    System.out.println("THE ELEMENTS ARE:");
                    q.display();
                    System.out.println();
                    break;
                case 5:
                    q.reverse();
                    q.display();
                    System.out.println();
                    break;
                case 6:
                    break;
            }
        }
        while(choice != 6);
        s.close();
    }
}
