package DataStructure;
import java.util.Scanner;
public class Search {
    public static int binarySearch(int arr[],int val){
        int index = -1;
        int l = 0, r = arr.length - 1;

        while(l <= r){
            int mid = (l + r)/2;
            
            if(arr[mid] == val){
                index = mid;
                break;
            }
            
            if(val > arr[mid]){
                l = mid+1;
            }
            
            if(val < arr[mid]){
                r = mid -1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }

        System.out.println("ENTER THE ELEMENT TO BE SEARCHED");
        int input = s.nextInt();
        int position = binarySearch(arr, input);
        if(position >= 0)
        System.out.println("ELEMENT IS PRESENT AT: "+position);
        else
        System.out.println("ELEMENT NOT FOUND");

        s.close();
    }
}
