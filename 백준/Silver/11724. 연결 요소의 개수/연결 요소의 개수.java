import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static void solve(int node){
        while(!queue.isEmpty()){
            int i = queue.poll();
            for(int j=1; j<=node; j++){
                if(mat[i][j]==1 && visited[j]==0){
                    queue.offer(j);
                    visited[j] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int node = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        mat = new int[node+1][node+1];
        visited = new int[node+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a][b] = 1;
            mat[b][a] = 1;
        }
        int count = 0;
        for(int i=1; i<=node; i++){
            if(visited[i]==0){
                visited[i] = 1;
                queue.offer(i);
                solve(node);
                count++;
            }
        }
        bw.write(count+"\n");
        bw.close();
    }
}

