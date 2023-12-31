package DataStructure;

import java.util.Scanner;

public class DoublyLinkedList {
    private class Node {
        Integer data;
        Node next;
        Node prev;

        Node(Integer data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    Node head,tail;
    Integer size;

    DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    void add(Integer val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        tail = newNode;
        
        size++;
    }

    void delete(Integer val) {
        if (head == null) {
            System.out.println("THE LIST IS EMPTY");
        } else {
            if (head.data == val) {
                head = head.next;
                head.prev = null;
            } else {
                Node temp = head;

                while (temp.next != null && temp.next.data != val) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    if (temp.next.data != val) {
                        System.out.println("THE ELEMENT IS NOT PRESENT IN THE LIST");
                        return;
                    } else {
                        if(temp.next.next == null) {
                            Node element = temp.next;
                            element.prev = null;
                            temp.next = null;
                            tail = temp;
                        }
                        else{
                            temp.next = temp.next.next;
                            temp.next.prev = temp;
                            System.out.println("THE ELEMENT HAS BEEN DELETED");
                        }
                    }
                }
                else{
                    if(temp.data == val){

                    }
                }
            }
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
        Node current = head;
        Node next = null, prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        current = head;
        current.prev = null;
        prev = null;
        while(current.next != null){
            prev = current;
            current = current.next;
            current.prev = prev;
        }
    }

    void insert(Integer position, Integer val) {
        if (position > size || position < 1) {
            System.out.println("ENTER A VALID POSITION");
        } else {
            Node newNode = new Node(val);
            Node temp = head;
            while (position-- > 2) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
            System.out.println("THE ELEMENT HAS BEEN INSERTED");
        }
    }

    void swap(Integer element1,Integer element2){
        Node firstElement = head,secondElement = head;

        while (firstElement != null && firstElement.data != element1) {
            firstElement = firstElement.next;
        }
        while (secondElement != null && secondElement.data != element2) {
            secondElement = secondElement.next;
        }

        if(firstElement == head && secondElement == tail){
            Node temp1 = secondElement.prev;
            Node temp2 = firstElement.next;

            temp1.next = firstElement;
            firstElement.next = null;
            firstElement.prev = temp1;

            secondElement.next = temp2;
            temp2.prev = secondElement;
            secondElement.prev = null;

            head = secondElement;
            tail = firstElement;
        }
        else if(firstElement == head && secondElement == head.next){
            Node temp1 = secondElement.next;
            
            firstElement.next = temp1;
            secondElement.next = firstElement;
            firstElement.prev = secondElement;
            temp1.prev = firstElement;

            head = secondElement;
        }
        else if(secondElement == tail && firstElement.next == tail){
            Node temp1 = firstElement.prev;

            secondElement.prev = temp1;
            secondElement.next = firstElement;
            temp1.next = secondElement;
            firstElement.prev = secondElement;
            firstElement.next = null;
            tail = firstElement;
        }
        else if(firstElement == head){
            Node temp1 = firstElement.next;
            Node temp2 = secondElement.prev;
            Node temp3 = secondElement.next;

            firstElement.next = temp3;
            firstElement.prev = temp2;
            temp2.next = firstElement;
            temp3.prev = firstElement;

            secondElement.next = temp1;
            secondElement.prev = null;
            temp1.prev = secondElement;

            head = secondElement;
        }
        else if(secondElement == tail){
            Node temp1 = firstElement.next;
            Node temp2 = firstElement.prev;
            Node temp3 = secondElement.prev;

            secondElement.next = temp1;
            secondElement.prev = temp2;
            temp1.prev = secondElement;
            temp2.next = secondElement;

            firstElement.prev = temp3;
            temp3.next = firstElement;
            firstElement.next = null;

            tail = firstElement;
        }
        else{
            if(firstElement.next == secondElement){
                Node temp1 = secondElement;
                Node temp2 = firstElement.prev;
                Node temp3 = secondElement.next;

                firstElement.next = temp3;
                firstElement.prev = secondElement;
                temp3.prev = firstElement;
                temp1.next = firstElement;

                secondElement.next = firstElement;
                secondElement.prev = temp2;
                temp2.next = secondElement;
                firstElement.prev = secondElement;
            }
            else{
                Node temp1 = firstElement.next;
                Node temp2 = firstElement.prev;
                Node temp3 = secondElement.next;
                Node temp4 = secondElement.prev;

                firstElement.next = temp3;
                firstElement.prev = temp4;
                temp3.prev = firstElement;
                temp4.next = firstElement;
                
                secondElement.next = temp1;
                secondElement.prev = temp2;
                temp1.prev = secondElement;
                temp2.next = secondElement;
            }
        }
    }

    void display() {
        Node temp = head;
        if(head == null){
            System.out.println("THE LIST IS EMPTY");
            return;
        }
        if (head != null) {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        } else {
            System.out.println("LIST IS EMPTY");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList l1 = new DoublyLinkedList();
        Scanner s = new Scanner(System.in);
        Integer choice = 0,input;
        do{
            System.out.println("1.INSERT   2.DELETE   3.FIND   4.DISPLAY   5.REVERSE   6.INSERT_AT   7.SWAP   8.EXIT");
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
                    System.out.println("ENTER THE ELEMENTS TO BE SWAPPED");
                    Integer position1 = s.nextInt(),position2 = s.nextInt();
                    l1.swap(position1, position2);
                    l1.display();
                    System.out.println();
                    break;
                case 8:
                    break;
            }
        }
        while(choice != 8);
        s.close();
    }
}
