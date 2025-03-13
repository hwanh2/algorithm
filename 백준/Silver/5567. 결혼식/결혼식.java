import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited;
    static int count = 0;
    static void solve(int n){
        visited[1] = 1;
        for(int i=1; i<=n; i++){
            if(array[1][i]==1){
                queue.offer(i);
                visited[i] = 1;
                count++;
            }
        }
        while(!queue.isEmpty()){
            int w = queue.poll();
            for(int i=1; i<=n; i++){
                if(array[w][i]==1 && visited[i]==0){
                    count++;
                    visited[i] = 1;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        array = new int[n+1][n+1];
        visited = new int[n+1];
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a][b] = 1;
            array[b][a] = 1;
        }
        solve(n);
    }
}