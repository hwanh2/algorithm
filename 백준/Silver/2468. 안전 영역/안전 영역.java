import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] array;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> queue;
    static void bfs(int water){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && visited[y][x]==0 && array[y][x]>water){
                    visited[y][x] = 1;
                    queue.offer(new int[] {y,x});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n][n];

        int maxArea = 0;
        int maxCount = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                maxArea = Math.max(array[i][j],maxArea);
            }
        }

        for(int i=0; i<=maxArea; i++){
            int count = 0;
            queue = new LinkedList<>();
            visited = new int[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(visited[j][k]==0 && array[j][k]>i){
                        queue.offer(new int[] {j,k});
                        visited[j][k] = 1;
                        bfs(i);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
}