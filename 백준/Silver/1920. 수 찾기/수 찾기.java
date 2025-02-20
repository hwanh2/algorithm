import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] nArray = new int[n];

       for(int i=0; i<nArray.length; i++){
           nArray[i] = sc.nextInt();
       }

       int m = sc.nextInt();
       int[] mArray = new int[m];

       for(int i=0; i<mArray.length; i++){
           mArray[i] = sc.nextInt();
       }

       Arrays.sort(nArray);

       for(int i=0; i<mArray.length; i++){
           if(Arrays.binarySearch(nArray,mArray[i])<0){
               System.out.println(0);
           }
           else{
               System.out.println(1);
           }
       }
    }
}
