package Assignment1;
import java.util.*;

import Assignment1.Interface.NestedInterface;
interface Interface{

    interface NestedInterface{
        void printMessage();
    }
    class NestedClass{
        void printMessage(){
            System.out.println("This message is from the nested class");
        }
    }
    interface InterfaceWithException{
        void division(Integer a, Integer b)throws RuntimeException;
    }
}

class NestedInterfaceImplementation implements NestedInterface{
    public void printMessage() {
        System.out.println("This message id from the nested interface");
    }
    public static void main(String[] args) {
        NestedInterface obj = new NestedInterfaceImplementation();
        obj.printMessage();
    }
}

public class NestedInterfaceException implements Interface.InterfaceWithException{
    public void printMessage(){
        System.out.println("This message is from the nested interface");
    }
    public void division(Integer a, Integer b){
        Integer res;
        try{
            res = a / b;
            System.out.println(res);
        }
        catch(Exception e){
            // throw new RuntimeException("The second number cannot be Zero");
            System.out.println("The second number cannot be Zero");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        NestedInterfaceException obj = new NestedInterfaceException();
        obj.division(s.nextInt(), s.nextInt());
        s.close();
    }
}