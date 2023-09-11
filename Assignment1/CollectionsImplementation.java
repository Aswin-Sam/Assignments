package Assignment1;

import java.util.*;

public class CollectionsImplementation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        Integer choice;
        do {
            System.out.println(
                    "1.INSERT   2.DELETE   3.INSERT_FIRST   4.INSERT_LAST   5.DELETE_FIRST   6.DELETE_LAST   7.DISPLAY   8.EXIT");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("ENTER THE NUMBER TO BE INSERTED");
                    Integer input = s.nextInt();
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

        s.close();
    }
}
