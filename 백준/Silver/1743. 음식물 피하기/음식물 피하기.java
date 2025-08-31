import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] array;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int result = 0;
    static Queue<int[]> queue;
    static void bfs(){
        int count = 0;
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            for(int i=0; i<4; i++){
                int x = tmp[1]+dx[i];
                int y = tmp[0]+dy[i];
                if(x>=0 && y>=0 && x<m && y<n && visited[y][x]==0 && array[y][x]==1){
                    queue.offer(new int[] {y,x});
                    visited[y][x] = 1;
                    count++;
                }
            }
        }
        result = Math.max(result, count);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine()," ");
            array[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]==1){
                    queue = new LinkedList<>();
                    queue.offer(new int[] {i,j});
                    visited[i][j] = 1;
                    bfs();
                }
            }
        }
        System.out.println(result+1);
    }
}
