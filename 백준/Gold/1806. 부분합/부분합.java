import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while(true){
            if(sum>=s){
                min = Math.min(min,end-start);
                sum-=array[start++];
            }
            else{
                if(end==n){
                    break;
                }
                sum+=array[end++];
            }
        }
        System.out.println(min==Integer.MAX_VALUE? 0 : min);
    }
}
