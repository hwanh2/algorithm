import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n;
    static int[] array;
    static int[] visited;
    static void backTracking(int depth){
        if(depth==n){
            for(int i=0; i<array.length-1; i++){
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
        }
        for(int i=1; i<=n; i++){
            if(visited[i]==0){
                array[depth] = i;
                visited[i] = 1;
                backTracking(depth+1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        visited = new int[n+1];
        backTracking(0);
        System.out.println(sb);
    }
}