import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dif = new int[n-1];
        for(int i=1; i<n; i++){
            dif[i-1] = array[i]-array[i-1];
        }

        Arrays.sort(dif);

        int count = 0;
        for(int i=0; i<n-k; i++){
            count+=dif[i];
        }
        System.out.println(count);

    }
}
