import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static char[][] mat;
    static int[][] distance;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> queue = new LinkedList<>();
    static int max = 0;
    static void bfs(){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<m && y<n && mat[y][x]=='L' && distance[y][x]==0){
                    queue.offer(new int[] {y,x});
                    distance[y][x] = distance[tmpY][tmpX]+1;
                    max = Math.max(max,distance[y][x]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat = new char[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                mat[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]=='L'){
                    queue.clear();
                    queue.offer(new int[] {i,j});
                    distance = new int[n][m];
                    distance[i][j] = 1;
                    bfs();
                }
            }
        }
        System.out.println(max-1);
    }
}

