package Assignment1;
import java.util.*;
public class fib{
    public static int fibonacci(int n){
        if(n == 1)
        return 0;
        else if(n == 2 || n == 3)
        return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibonacci(n));
        s.close();
    }
}