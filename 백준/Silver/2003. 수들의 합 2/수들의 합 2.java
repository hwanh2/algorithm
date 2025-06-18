import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int sum = 0;

       while (true) {
            if (sum >= m) {
                sum -= array[start++];
            } else if(end==n){
                break;
            } else{
                sum+=array[end++];
            }
           
           if(sum==m){
               count++;
           }
        }
        System.out.println(count);
    }
}