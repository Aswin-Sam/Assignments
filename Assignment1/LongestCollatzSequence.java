package Assignment1;
public class LongestCollatzSequence{
    public static void main(String[] args) {
        long max = 0;
        long startingTerm = 0;
        for(long i=1;i<=1000000;i++){
            long n = i;
            long count = 1;

            while(n != 1){
                if(n %2 == 0){
                    n = n/2;
                }else{
                    n = (3*n)+1;
                }
                count++;
            }

            if(max < count){
                max = count;
                startingTerm = i;
            }
            
        }

        System.out.println(startingTerm);
    }
}