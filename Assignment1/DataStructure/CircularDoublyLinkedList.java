package Assignment1.DataStructure;
import java.util.Scanner;
public class CircularDoublyLinkedList {
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

    CircularDoublyLinkedList(){
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
            while (temp != tail) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        tail = newNode;
        tail.next = head;
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
                    head.prev = tail;
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
                head.prev = tail;
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
                    temp.next.prev = temp;
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

    Node removeFirst(){
        Node temp = head;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return temp;
    }

    // void swap(Node element1,Node element2){
    //     Node firstElement = head,secondElement = head;

    //     while(firstElement != element1){
    //         firstElement = firstElement.next;
    //     }
    //     while(secondElement != element2){
    //         secondElement = secondElement.next;
    //     }
    // }

    void swap(Integer position1,Integer position2){
        Node firstElement = head,secondElement = head;

        for(int i=1;i<position1;i++){
            firstElement = firstElement.next;
        }
        for(int i=1;i<position2;i++){
            secondElement = secondElement.next;
        }

        if(firstElement == head && secondElement == tail){
            Node temp1 = firstElement.next;
            Node temp2 = secondElement.prev;
            
            Node temp = firstElement;
            
            firstElement.next = secondElement;
            firstElement.prev = secondElement.prev;
            temp2.next = firstElement;
            secondElement.next = temp1;
            secondElement.prev = temp;
            temp1.prev = secondElement;
            head = secondElement;
            tail = firstElement;
        }
        else if(firstElement == head && firstElement.next == secondElement){
            Node temp1 = secondElement.next;
            
            firstElement.next = temp1;
            secondElement.next = firstElement;
            firstElement.prev = secondElement;
            temp1.prev = firstElement;

            tail.next = secondElement;
            secondElement.prev = tail;
            head = secondElement;
        }
        else if(secondElement == tail && secondElement.prev == firstElement){
            Node temp1 = firstElement.prev;

            secondElement.prev = temp1;
            secondElement.next = firstElement;
            temp1.next = secondElement;
            firstElement.prev = secondElement;

            firstElement.next = head;
            head.prev = firstElement;
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
            secondElement.prev = tail;
            tail.next = secondElement;
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
            firstElement.next = head;
            head.prev = firstElement;

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

    void reverse(){
        int i = 1,j = size;

        while(i < j){
            swap(i,j);
            i++;
            j--;
        }
    }

    void insert(Integer position, Integer val) {
        if (position > size) {
            System.out.println("ENTER A VALID POSITION");
        }
        else if(position == 1){
            Node newNode = new Node(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
            head.prev = tail;
            size++;
        }
        else {
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
        CircularDoublyLinkedList l1 = new CircularDoublyLinkedList();
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
                    System.out.println("ENTER THE POSITIONS OF TWO ELEMENTS TO BE SWAPPED");
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
