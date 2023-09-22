package DataStructure;
import java.util.*;
public class Sort {
    void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            int curMax = arr[i];

            for(int j=i+1;j<arr.length;j++){
                if(curMax > arr[j]){
                    curMax = arr[j];
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    void cocktailSort(int arr[]){
        boolean swap = false;
        int i=0,counter=0;
        for(i=0;i<arr.length;i++,counter++){
            swap = false;
            for(int j=i+1;j<arr.length-i;j++,counter++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
            for(int j=arr.length-1-i;j>i;j--,counter++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
        System.out.println(counter);
    }

    void bubbleSort(int arr[]){
        int counter = 0;
        for(int i=0;i<arr.length;i++,counter++){
            for(int j=i+1;j<arr.length-i;j++,counter++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(counter);
    }

    public static int partition(int a[],int l,int h){
        int i=l ,j=h,pivot=a[(l+h)/2],temp; 
        while(i<=j){
            while(i<=h && a[i]<pivot) 
            i++;
            while(a[j]>pivot) 
            j--;
            if(i<=j){
                temp=a[i]; 
                a[i]=a[j]; 
                a[j]=temp;
                i++;
                j--;
            }
        }

        return i;
    }
    
    void quickSort(int a[],int l,int h){
        if(l<h){
            int m=partition(a,l,h); 
            quickSort(a,l,m-1);
            quickSort(a,m,h);
        }
    }

    public static void main(String[] args) {
        Sort srt = new Sort();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[i] = s.nextInt();
        }

        srt.quickSort(a,0,n-1);
        System.out.println(Arrays.toString(a));

        s.close();
    }
}
