import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static boolean bfs(int r,int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        visited[r][c] = true;
        boolean flag = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[1];
            int cy = cur[0];

            for(int i=0; i<8; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if(map[ny][nx]>map[cy][cx]){
                        flag = false;
                    }
                    if(map[ny][nx]==map[cy][cx] && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        queue.add(new int[] {ny,nx});
                    }
                }
            }
        }
        return flag;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]){
                    if(bfs(i,j)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}