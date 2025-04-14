import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] mat;
    static Queue<int[]> queue;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static StringBuilder sb;
    static void bfs(int goalX,int goalY){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            if(tmpX==goalX && tmpY==goalY){
                sb.append(mat[tmpY][tmpX]-1).append("\n");
                return;
            }
            for(int i=0; i<8; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && mat[y][x]==0){
                    queue.offer(new int[] {y,x});
                    mat[y][x] = mat[tmpY][tmpX]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            mat = new int[n][n];
            queue = new LinkedList<>();
            
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.offer(new int[] {a,b});
            mat[a][b] = 1;
            
            st = new StringTokenizer(br.readLine()," ");
            int goalY = Integer.parseInt(st.nextToken());
            int goalX = Integer.parseInt(st.nextToken());

            bfs(goalX,goalY);

        }
        System.out.println(sb);

    }
}


