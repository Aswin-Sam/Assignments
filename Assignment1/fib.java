package Assignment1;
import java.util.*;
public class fib{
    public static int fibonacciUsingRecursion(int n){
        if(n == 1)
        return 0;
        else if(n == 2 || n == 3)
        return 1;

        return fibonacciUsingRecursion(n-1) + fibonacciUsingRecursion(n-2);
    }
    public static void recursion(int n,int m){
        if(n >= m){
            System.out.print(fibonacciUsingRecursion(m)+" ");
            recursion(n,m+1);
        }
    }
    public static int fibocacciUsingLoop(int n){
        int fib[] = new int[n+1];
        fib[0]=0;
        fib[1]=1;

        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        // System.out.println(fibonacciUsingRecursion(n)+"");
        recursion(n,1);
        s.close();
    }
}