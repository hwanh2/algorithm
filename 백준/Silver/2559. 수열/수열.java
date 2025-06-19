import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int start = 0;
        int end = k-1;
        for(int i=0; i<k; i++){
            sum+=array[i];
        }

        int result = sum;

        for(int i=0; i<n-k; i++){
            sum -=array[start++];
            sum += array[++end];
            result = Math.max(result,sum);
        }

        System.out.println(result);
    }
}
