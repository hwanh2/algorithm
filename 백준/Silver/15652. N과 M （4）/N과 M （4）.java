import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int[] visited;
    static StringBuilder sb;
    static void backTracking(int start,int num){
        if(num == m){
            for(int i=0; i<m; i++){
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=n; i++){
            array[num] = i;
            backTracking(i,num+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        visited = new int[n+1];
        backTracking(1,0);
        System.out.print(sb);
    }
}
