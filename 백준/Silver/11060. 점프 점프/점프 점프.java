import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static int[] visited;
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        visited[0] = 1;

        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]==n-1){
                return tmp[1];
            }
            for(int i=1; i<=array[tmp[0]]; i++){
                int next = tmp[0]+i;
                if(next<n && visited[next]==0){
                    queue.offer(new int[] {next,tmp[1]+1});
                    visited[next] = 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        visited = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }
}
