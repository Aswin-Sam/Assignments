package Assignment1;

import java.util.*;

public class CollectionsImplementation {
    public static void main(String[] args) {
        Integer choice, input;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("1.LIST   2.QUEUE   3.SET   4.MAP   5.TABLE   6.EXIT");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1.ARRAYLIST   2.LINKEDLIST   3.VECTOR   4.STACK   5.BACK");
                    choice = s.nextInt();
                    switch (choice) {
                        case 1:
                            ArrayList<Integer> arrList = new ArrayList<>();
                            do{
                                System.out.println("1.INSERT   2.DELETE   3.DISPLAY   4.BACK");
                                choice = s.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.println("ENTER THE NUMBER TO BE INSERTED");
                                        input = s.nextInt();
                                        arrList.add(input);
                                        break;
                                    case 2:
                                        System.out.println("ENTER THE NUMBER TO BE DELETED");
                                        input = s.nextInt();
                                        if (arrList.remove(input)) {
                                            System.out.println("THE ELEMENT IS DELETED");
                                            for (Integer element : arrList) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                        } else {
                                            System.out.println("THE ENTERED NUMBER IS NOT PRESENT IN THE DEQUEUE");
                                        }
                                        break;
                                    case 3:
                                        for (Integer element : arrList) {
                                            System.out.print(element + " ");
                                        }
                                        System.out.println();
                                        break;
                                    case 4:
                                        break;
                                }
                            }
                            while(choice != 4);
                            break;
                        case 2:
                            LinkedList<Integer> linkList = new LinkedList<>();
                            do{
                                System.out.println("1.INSERT   2.DELETE   3.DISPLAY   4.BACK");
                                choice = s.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.println("ENTER THE NUMBER TO BE INSERTED");
                                        input = s.nextInt();
                                        linkList.add(input);
                                        break;
                                    case 2:
                                        System.out.println("ENTER THE NUMBER TO BE DELETED");
                                        input = s.nextInt();
                                        if (linkList.remove(input)) {
                                            System.out.println("THE ELEMENT IS DELETED");
                                            for (Integer element : linkList) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                        } else {
                                            System.out.println("THE ENTERED NUMBER IS NOT PRESENT IN THE DEQUEUE");
                                        }
                                        break;
                                    case 3:
                                        for (Integer element : linkList) {
                                            System.out.print(element + " ");
                                        }
                                        System.out.println();
                                        break;
                                    case 4:
                                        break;
                                }
                            }
                            while(choice != 4);
                            break;
                        case 3:
                            Vector<Integer> vector = new Vector<>();
                            do{
                                System.out.println("1.INSERT   2.DELETE   3.DISPLAY   4.BACK");
                                choice = s.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.println("ENTER THE NUMBER TO BE INSERTED");
                                        input = s.nextInt();
                                        vector.add(input);
                                        break;
                                    case 2:
                                        System.out.println("ENTER THE NUMBER TO BE DELETED");
                                        input = s.nextInt();
                                        if (vector.remove(input)) {
                                            System.out.println("THE ELEMENT IS DELETED");
                                            for (Integer element : vector) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                        } else {
                                            System.out.println("THE ENTERED NUMBER IS NOT PRESENT IN THE DEQUEUE");
                                        }
                                        break;
                                    case 3:
                                        for (Integer element : vector) {
                                            System.out.print(element + " ");
                                        }
                                        System.out.println();
                                        break;
                                    case 4:
                                        break;
                                }
                            }
                            while(choice != 4);
                            break;
                        case 4:
                            Stack<Integer> stack = new Stack<>();
                            do{
                                System.out.println("1.INSERT   2.DELETE   3.DISPLAY   4.BACK");
                                choice = s.nextInt();
                                switch (choice) {
                                    case 1:
                                        System.out.println("ENTER THE NUMBER TO BE INSERTED");
                                        input = s.nextInt();
                                        stack.push(input);
                                        break;
                                    case 2:
                                        System.out.println("ENTER THE NUMBER TO BE DELETED");
                                        input = s.nextInt();
                                        if (!stack.empty()) {
                                            stack.pop();
                                            System.out.println("THE ELEMENT IS DELETED");
                                            for (Integer element : stack) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                        } else {
                                            System.out.println("THE ENTERED NUMBER IS NOT PRESENT IN THE DEQUEUE");
                                        }
                                        break;
                                    case 3:
                                        for (Integer element : stack) {
                                            System.out.print(element + " ");
                                        }
                                        System.out.println();
                                        break;
                                    case 4:
                                        break;
                                }
                            }
                            while(choice != 4);
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 2:
                    do{
                        System.out.println("1.PRIORITY QUEUE   2.ARRAY DEQUE   3.BACK");
                        choice = s.nextInt();
                        switch (choice) {
                            case 1:
                                PriorityQueue<Integer> pq = new PriorityQueue<>();
                                do{
                                    System.out.println(
                                            "1.INSERT   2.DELETE   3.DELETE THE PRIORITORIZED ELEMENT   4.DISPLAY   5.BACK");
                                    choice = s.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println("ENTER THE NUMBER TO BE INSERTED");
                                            input = s.nextInt();
                                            pq.add(input);
                                            break;
                                        case 2:
                                            System.out.println("ENTER THE ELEMENT TO BE DELETED");
                                            input = s.nextInt();
                                            pq.remove(input);
                                            for (Integer element : pq) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                            break;
                                        case 3:
                                            System.out.println(pq.poll());
                                            break;
                                        case 4:
                                            for (Integer element : pq) {
                                                System.out.print(element + " ");
                                            }
                                            break;
                                        case 5:
                                            break;
                                    }
                                }
                                while(choice != 5);
                                break;
                            case 2:
                                Deque<Integer> dq = new ArrayDeque<>();
                                do {
                                    System.out.println(
                                            "1.INSERT   2.DELETE   3.INSERT_FIRST   4.INSERT_LAST   5.DELETE_FIRST   6.DELETE_LAST   7.DISPLAY   8.BACK");
                                    choice = s.nextInt();
        
                                    switch (choice) {
                                        case 1:
                                            System.out.println("ENTER THE NUMBER TO BE INSERTED");
                                            input = s.nextInt();
                                            dq.add(input);
                                            break;
                                        case 2:
                                            System.out.println("ENTER THE NUMBER TO BE DELETED");
                                            input = s.nextInt();
                                            if (dq.remove(input)) {
                                                System.out.println("THE ELEMENT IS DELETED");
                                                for (Integer element : dq) {
                                                    System.out.print(element + " ");
                                                }
                                                System.out.println();
                                            } else {
                                                System.out.println("THE ENTERED NUMBER IS NOT PRESENT IN THE DEQUEUE");
                                            }
                                            break;
                                        case 3:
                                            System.out.println("ENTER THE NUMBER TO BE INSERTED FIRST");
                                            input = s.nextInt();
                                            dq.addFirst(input);
                                            break;
                                        case 4:
                                            System.out.println("ENTER THE NUMBER TO BE INSERTED LAST");
                                            input = s.nextInt();
                                            dq.addLast(input);
                                            break;
                                        case 5:
                                            dq.removeFirst();
                                            for (Integer element : dq) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                            break;
                                        case 6:
                                            dq.removeLast();
                                            for (Integer element : dq) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                            break;
                                        case 7:
                                            for (Integer element : dq) {
                                                System.out.print(element + " ");
                                            }
                                            System.out.println();
                                            break;
                                        case 8:
                                            break;
                                    }
                                } while (choice != 8);
                                break;
                            case 3:
                            break;
                        }
                    }
                    while(choice != 3);
                    break;
                case 3:
                do{
                    System.out.println("1.HASH SET   2.LINKED HASH SET   3.TREE SET   4.BACK");
                    choice = s.nextInt();
                    switch(choice){
                        case 1:
                            HashSet<Integer>hashSet = new HashSet<>();
                            do{
                                System.out.println("1.INSERT   2.DELETE   3.DISPLAY   4.BACK");
                                switch(choice){

                                }
                            }
                            while(choice != 4);
                    }
                }
                while(choice != 4);
            }

        }
        while(choice != 6);
        s.close();
    }
}
