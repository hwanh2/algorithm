import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static boolean[] visited;
    static StringBuilder sb;
    static void backTracking(int num){
        if(num==m){
            for(int i=0; i<m; i++){
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                array[num] = i;
                visited[i] = true;
                backTracking(num+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[m];
        visited = new boolean[n+1];
        backTracking(0);
        System.out.println(sb);
    }
}
