import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(array[i]+array[j]==m){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
