import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[] distance;
    static Queue<Integer> queue;
    static int num;
    static void bfs(int start){
        queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 1;
        while(!queue.isEmpty()){
            int from = queue.poll();
            for(int i=1; i<=num; i++){
                if(mat[from][i]==1 && distance[i]==0){
                    queue.offer(i);
                    distance[i] = distance[from]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        mat = new int[num+1][num+1];
        distance = new int[num+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a][b] = 1;
            mat[b][a] = 1;
        }

        bfs(start);
        System.out.println(distance[goal]-1);

    }
}