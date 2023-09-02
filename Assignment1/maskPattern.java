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
    public static void printStar(int i,int n){
        if(i < n){
            System.out.print("*");
            printStar(i+1, n);
        }
    }
    public static void printMinus(int i,int n){
        if(i < n){
            System.out.print("-");
            printMinus(i+1, n);
        }
    }
    public static void printSpace(int i,int n){
        if(i < n){
            System.out.print(" ");
            printSpace(i+1, n);
        }
    }
    public static void upperBlock(int i,int n){
        if(i < n){
            printStar(0,i+1);
            printSpace(i,n-1);
            printSpace(i,n-1);
            printStar(0,i+1);
            System.out.println();
            upperBlock(i+1, n);
        }
    }
    public static void lowerBlock(int i,int n){
        if(i < n){
            printMinus(i, n);
            printSpace(0,i);
            printSpace(0,i);
            printMinus(i,n);
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
    }
}
