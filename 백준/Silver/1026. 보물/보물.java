import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] array1 = new int[n];
        Integer[] array2 = new Integer[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array1);
        Arrays.sort(array2,Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<n; i++){
            sum+=array1[i]*array2[i];
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}
