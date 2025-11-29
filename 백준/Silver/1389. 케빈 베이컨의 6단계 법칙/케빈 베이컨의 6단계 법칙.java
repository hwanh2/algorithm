import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] distance;
    static Queue<Integer> queue;
    static int min = Integer.MAX_VALUE;
    static int result = 0;
    static void bfs(int start){
        queue.add(start);
        distance[start] = 1;
        while (!queue.isEmpty()){
            int num = queue.poll();

            for(int i=1; i<=n; i++){
                if(map[num][i]==1 && distance[i]==0){
                    distance[i] = distance[num]+1;
                    queue.add(i);
                }
            }
        }

        int sumStart = 0;
        for(int i=1; i<=n; i++){
            sumStart+=distance[i];
        }

        if(sumStart<min){
            min = sumStart;
            result = start;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i=1; i<=n; i++){
            queue = new LinkedList<>();
            distance = new int[n+1];
            bfs(i);
        }

        System.out.println(result);
        
    }
}