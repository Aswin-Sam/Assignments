package DataStructure;

import java.util.Scanner;;


public class SinglyLinkedList {
    Node head;
    Integer size;
    private class Node {
        Integer data;
        Node next;
    
        Node(Integer data) {
            this.data = data;
            next = null;
        }
    }

    SinglyLinkedList() {
        head = null;
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
        }

        size++;
    }

    void delete(Integer val) {
        if (head == null) {
            System.out.println("THE LIST IS EMPTY");
        } else {
            if (head.data == val) {
                head = head.next;
            } else {
                Node temp = head;

                while (temp.next != null && temp.next.data != val) {
                    temp = temp.next;
                }
                if (temp.next != null) {
                    if (temp.next.data != val) {
                        System.out.println("THE ELEMENT IS NOT PRESENT IN THE LIST");
                        return;
                    } else{
                        temp.next = temp.next.next;
                        System.out.println("THE ELEMENT HAS BEEN DELETED");
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

    void insert(Integer position, Integer val) {
        if (position > size || position < 1) {
            System.out.println("ENTER A VALID POSITION");
            return;
        } 
        else if(position == 1){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
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
        }
        System.out.println("THE ELEMENT HAS BEEN INSERTED");
    }

    void swap(Integer element1,Integer element2){
        Node firstElement = head, secondElement = head;

        while (firstElement != null && firstElement.data != element1) {
            firstElement = firstElement.next;
        }
        while (secondElement != null && secondElement.data != element2) {
            secondElement = secondElement.next;
        }

        if(firstElement == head && secondElement.next == null){
            Node temp = head;

            while(temp.next.next != null){
                temp = temp.next;
            }
            secondElement.next = firstElement.next;
            firstElement.next = null;

            temp.next = firstElement;

            head = secondElement;
        }
        else if(firstElement == head && firstElement.next == secondElement){
            firstElement.next = secondElement.next;
            secondElement.next = firstElement;
            head = secondElement;
        }
        else if(firstElement.next.next == null && secondElement.next == null){
            Node temp = head;

            while(temp.next.data != firstElement.data){
                temp = temp.next;
            }

            temp.next = secondElement;
            secondElement.next = firstElement;
            firstElement.next = null;
        }
        else if(firstElement == head){
            Node temp1 = head,temp2 = head.next;
            while(temp1.next.data != secondElement.data){
                temp1 = temp1.next;
            }

            temp1.next = firstElement;
            firstElement.next = secondElement.next;
            secondElement.next = temp2;

            head = secondElement;
        }
        else if(secondElement.next == null){
            Node temp1 = head,temp2 = head;

            while(temp1.next.data != firstElement.data){
                temp1 = temp1.next;
            }

            while(temp2.next.next != null){
                temp2 = temp2.next;
            }

            temp1.next = secondElement;
            secondElement.next = firstElement.next;
            firstElement.next = null;
            temp2.next = firstElement;
        }
        else{
            if(firstElement.next == secondElement){
                Node temp1 = head;

                while(temp1.next.data != firstElement.data){
                    temp1 = temp1.next;
                }

                firstElement.next = secondElement.next;
                temp1.next = secondElement;
                secondElement.next = firstElement;
            }
            else{
                Node temp1 = head,temp2 = head;

                while(temp1.next.data != firstElement.data){
                    temp1 = temp1.next;
                }

                while(temp2.next.data != secondElement.data){
                    temp2 = temp2.next;
                }

                Node temp3 = firstElement.next;

                firstElement.next = secondElement.next;
                temp2.next = firstElement;
                temp1.next = secondElement;
                secondElement.next = temp3;
            }
        }
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
        SinglyLinkedList l1 = new SinglyLinkedList();
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
