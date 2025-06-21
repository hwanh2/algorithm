import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long max = 0;

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,array[i]);
        }
        max++;
        int m = Integer.parseInt(br.readLine());

        long min = 0;
        while(min<max){
            long count = 0;
            long mid = (min+max)/2;
            for(int i=0; i<n; i++){
                if(array[i]<mid){
                    count+=array[i];
                }
                else{
                    count+=mid;
                }
            }
            if(count<=m){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        System.out.println(min-1);
    }
}
