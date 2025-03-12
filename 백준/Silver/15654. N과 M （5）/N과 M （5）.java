import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static int[] input;
    static int[] array;
    static int[] visited;
    static void backTracking(int num){
        if(num==m){
            for(int i=0; i<m; i++){
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                array[num] = input[i];
                visited[i] = 1;
                backTracking(num+1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        array = new int[m];
        visited = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backTracking(0);
        System.out.println(sb);
    }
}
