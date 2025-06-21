import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int[] array = new int[n];
        long max = 0;
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,array[i]);
        }

        long min = 0;

        while(min<max){
            long mid = (min+max)/2;
            long count = 0;
            for(int i=0; i<n; i++){
                if(array[i]>mid){
                    count+=array[i]-mid;
                }
            }
            if(count>=m){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        System.out.println(min-1);
    }
}
