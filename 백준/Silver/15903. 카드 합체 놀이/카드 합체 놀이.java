import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] array = new long[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Long.parseLong(st.nextToken());
        }

        for(int i=0; i<m; i++){
            Arrays.sort(array);
            long tmp = array[0]+array[1];
            array[0] = tmp;
            array[1] = tmp;
        }

        long result = 0;
        for(int i=0; i<n; i++){
            result+=array[i];
        }

        System.out.println(result);

    }
}
