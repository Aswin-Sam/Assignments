package Assignment1;
import java.util.*;
public class maskPattern {
    public static void maskPatternUsingLoops(int n){
        System.out.println("Using Loops");

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=i;j<n-1;j++){
                System.out.print(" ");
            }
            for(int j=i;j<n-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                System.out.print("-");
            }
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=i;j<n;j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print(int i,int n,char symbol){
        if(i < n){
            System.out.print(symbol);
            print(i+1, n,symbol);
        }
    }
    public static void upperBlock(int i,int n){
        if(i < n){
            print(0,i+1,'*');
            print(i,n-1,' ');
            print(i,n-1,' ');
            print(0,i+1,'*');
            System.out.println();
            upperBlock(i+1, n);
        }
    }
    public static void lowerBlock(int i,int n){
        if(i < n){
            print(i, n,'-');
            print(0,i,' ');
            print(0,i,' ');
            print(i,n,'-');
            System.out.println();
            lowerBlock(i+1, n);
        }
    }
    public static void maskPatternUsingRecursion(int n){
        System.out.println("Using Recursion");
        upperBlock(0, n);
        lowerBlock(0, n);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        maskPatternUsingLoops(n);
        maskPatternUsingRecursion(n);
        s.close();
    }
}
