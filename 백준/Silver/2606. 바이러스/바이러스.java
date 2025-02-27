import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[] distance;
    static Queue<Integer> queue = new LinkedList<>();
    static void solve(int node){
        queue.offer(1);
        distance[1] = 1;
        int count = 0;
        while(!queue.isEmpty()){
            int start = queue.poll();
            for(int i=0; i<=node; i++){
                if(mat[start][i] == 1 && distance[i]==0){
                    queue.offer(i);
                    count++;
                    distance[i] = 1;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        int edge =  Integer.parseInt(br.readLine()); // 간선의 개수
        mat = new int[node+1][node+1];
        distance = new int[node+1];

        for(int i=0; i<edge; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a][b] = 1;
            mat[b][a] = 1;
        }
        solve(node);
    }
}
