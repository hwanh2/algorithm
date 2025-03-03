import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[][] distance;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> queue = new LinkedList<>();
    static void bfs(int n,int m){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && x<m && y>=0 && y<n && distance[y][x]==-1){
                    distance[y][x] = distance[tmpY][tmpX]+1;
                    queue.offer(new int[] {y,x});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        distance = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                mat[i][j] = tmp;
                if(tmp==1){
                    distance[i][j] = -1;
                }
                if(tmp==2){
                    queue.offer(new int[] {i,j});
                    distance[i][j] = 0;
                }
                if(tmp==0){
                    distance[i][j] = 0;
                }
            }
        }
        bfs(n,m);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                bw.write(distance[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}