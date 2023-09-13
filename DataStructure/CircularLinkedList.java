package DataStructure;

import java.util.Scanner;

public class CircularLinkedList {
    private class Node{
        Integer data;
        Node next;
    
        Node(Integer data) {
            this.data = data;
            next = null;
        }
    }
    Node head,tail;
    Integer size;

    CircularLinkedList(){
        head = tail = null;
        size = 0;
    }

    void add(Integer val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }
        else{
            Node temp = head;
            while(temp != tail){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        tail = newNode;
        size++;
    }

    void delete(Integer val){
        if(head == null){
            System.out.println("THE LIST IS EMPTY");
            return;
        }
        else{
            if(head.data == val){
                if(head.next == head){
                    head = tail = null;
                    return;
                }
                else{
                    head = head.next;
                    tail.next = head;
                }
            }
            else if(tail.data == val){
                Node temp = head.next;
                while(temp.next != tail){
                    temp = temp.next;
                }
                temp.next = head;
                tail = temp;
            }
            else{
                Node temp = head.next;
                
                while(temp.next != tail && temp.next.data != val){
                    temp = temp.next;
                }

                if(temp.next.data != val){
                    System.out.println("THE ENETERED ELEMENT IS NOT PRESENT IN THE LIST");
                    return;
                }
                else{
                    temp.next = temp.next.next;
                }
            }
        }
        size--;
        System.out.println("THE ELEMENT HAS BEEN DELETED");
    }

    Boolean find(Integer val) {
        if(head.data == val) return true;
        
        Node temp = head.next;

        while (temp != head) {
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
        Node temp = head;
        while (current != tail) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        tail.next = head;
        head = tail;
        tail = temp;
        tail.next = head;
    }

    void insert(Integer position, Integer val) {
        if (position > size) {
            System.out.println("ENTER A VALID POSITION");
        }
        else if(position == 1){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            tail.next = head;
            size++;
        }
        else {
            Node newNode = new Node(val);
            Node temp = head;
            while (position-- > 2) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
            System.out.println("THE ELEMENT HAS BEEN INSERTED");
        }
    }

    void display(){
        Node temp = head;
        if(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        while(temp != null && temp != head){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList l1 = new CircularLinkedList();
        Scanner s = new Scanner(System.in);
        Integer choice = 0,input;
        do{
            System.out.println("1.INSERT   2.DELETE   3.FIND   4.DISPLAY   5.REVERSE   6.INSERT_AT   7.EXIT");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    System.out.println("ENTER THE NUMBER TO BE INSERTED");
                    input = s.nextInt();
                    l1.add(input);
                    System.out.println("THE ELEMENT HAS BEEN INSERTED");
                    break;
                case 2:
                    System.out.println("ENTER THE NUMBER TO BE DELETED");
                    input = s.nextInt();
                    l1.delete(input);
                    break;
                case 3:
                    System.out.println("ENTER THE NUMBER TO FIND");
                    input = s.nextInt();
                    if(l1.find(input)){
                        System.out.println("THE ELEMENT IS PRESENT IN THE LIST");
                    }
                    else{
                        System.out.println("THE ELEMENT IS NOT PRESENT IN THE LIST");
                    }
                    break;
                case 4:
                    System.out.println("THE ELEMENTS ARE:");
                    l1.display();
                    System.out.println();
                    break;
                case 5:
                    l1.reverse();
                    l1.display();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("ENTER THE POSITION AND THE ELEMENT TO BE INSERTED");
                    Integer position = s.nextInt();
                    input = s.nextInt();
                    l1.insert(position, input);
                    break;
                case 7:
                    break;
            }
        }
        while(choice != 7);
        s.close();
    }
}
