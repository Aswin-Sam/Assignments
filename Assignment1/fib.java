package Assignment1;
import java.math.BigInteger;
import java.util.*;
public class fib{
    static HashMap<Integer,BigInteger>map = new HashMap<>();
    static int n,k = 1;
    public static BigInteger fibonacciUsingRecursion(int n){
        if(!map.containsKey(n)){
            BigInteger a = fibonacciUsingRecursion(n-1),b = fibonacciUsingRecursion(n-2);
            map.put(n,a.add(b));
        }
        return map.get(n);
    }
    public static void recursion(int n,int m){
        if(n >= m){
            System.out.print(fibonacciUsingRecursion(m)+" ");
            recursion(n,m+1);
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        map.put(1,BigInteger.valueOf(0));
        map.put(2,BigInteger.valueOf(1));
        boolean val = false;
        while(true){
            System.out.println("Enter the number:");
            String str = s.nextLine();
            String temp = str.replaceAll("[^0-9]", "");
            if(temp.length() == str.length()){
                if(val){
                    k = n + 1;
                }
                n += Integer.parseInt(str);
                val = true;
                recursion(n,k);
                System.out.println();
            }
            else{
                break;
            }
        }
        s.close();
    }
}