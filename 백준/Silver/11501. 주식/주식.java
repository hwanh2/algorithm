import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            long max = array[n-1];
            for(int j=n-2; j>=0; j--){
                if(array[j]<=max){
                    sum+=max-array[j];
                }
                else{
                    max = array[j];
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}