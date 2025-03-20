import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] distance = new int[n-1];
        int[] node = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            node[i] = Integer.parseInt(st.nextToken());
        }
        int min = node[0];
        for(int i=1; i<n; i++){
            if(min<node[i]){
                node[i] = min;
            }
        }
        int sum = 0;
        for(int i=0; i<n-1; i++){
            sum+=node[i]*distance[i];
        }
        System.out.println(sum);
        

    }
}