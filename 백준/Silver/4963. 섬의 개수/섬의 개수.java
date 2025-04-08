import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0,0,1,-1,-1,-1,1,1};
    static int[] dy = {1,-1,0,0,-1,1,-1,1};
    static int w;
    static int h;
    static void bfs(){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<8; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<w && y<h && mat[y][x]==1 && visited[y][x]==0){
                    queue.offer(new int[] {y,x});
                    visited[y][x] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0){
                System.out.println(sb);
                return;
            }
            mat = new int[h][w];
            visited = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<w; j++){
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(mat[i][j]==1 && visited[i][j]==0){
                        queue.offer(new int[] {i,j});
                        visited[i][j] = 1;
                        bfs();
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
    }
}

