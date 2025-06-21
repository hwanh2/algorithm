import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[k];
        long max = 0;
        for(int i=0; i<k; i++){
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,array[i]);
        }
        max++;
        long min = 0, mid = 0;

        while(min<max){
            int count = 0;
            mid = (max+min)/2;
            for(int i=0; i<array.length; i++){
                count+=array[i]/mid;
            }

            if(count<n){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
