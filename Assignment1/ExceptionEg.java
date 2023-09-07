package Assignment1;

import java.util.Scanner;

class CustomException extends Exception{
    CustomException(String message){
        super(message);
        System.out.println("This is a custom Exception");
    }
}

public class ExceptionEg{
    public static void isValidAge(Integer age){
        try{
            if(age < 18){
                throw new CustomException("The age is not valid");
            }
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        isValidAge(s.nextInt());
        s.close();
    }
}

class NullException{
    public static void main(String[] args) {
        try{
            String str = null;
            if(str.equals("null"))
            System.out.println("Equal");
            else
            System.out.println("Not Equal");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
