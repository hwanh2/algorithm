import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] array;
    static int[][] distance;
    static Queue<int[]> queue;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs(){
        int area = 1;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];

            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<m && y<n && array[y][x]==1 && distance[y][x]==0){
                    queue.offer(new int[] {y,x});
                    distance[y][x] = 1;
                    area++;
                }
            }
        }
        return area;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        distance = new int[n][m];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(array[i][j]==1 && distance[i][j]==0){
                    distance[i][j] = 1;
                    queue.add(new int[] {i,j});
                    int area = bfs();
                    max = Math.max(max,area);
                    count++;
                }
            }
        }
        sb.append(count).append("\n").append(max);
        System.out.println(sb);

    }
}