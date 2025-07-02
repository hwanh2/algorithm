import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        for(int i=0; i<n; i++){
            if(l>=array[i]){
                l++;
            }
        }
        System.out.println(l);
    }
}
