import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void dfs(int depth, int s, int start){
        if(depth==7){
            if(s>=4){
                bfs((start)%5, (start)/5);
            }
            return;
        }
        for(int i=start+1; i<25; i++){
            int r = i/5;
            int c = i%5;

            visited[r][c] = true;
            if(map[r][c] == 'S'){
                dfs(depth+1,s+1,i);
            } else {
                dfs(depth+1,s,i);
            }
            visited[r][c] = false;
        }
    }
    static void bfs(int x,int y){
        int count = 1;
        boolean[][] visited2 = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{y,x});
        visited2[y][x] = true;

        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cx = c[1];
            int cy = c[0];
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<5 && ny<5 && visited[ny][nx] && !visited2[ny][nx]){
                    queue.add(new int[] {ny,nx});
                    visited2[ny][nx] = true;
                    count++;
                }
            }
        }

        if(count==7) {
            result++;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        visited = new boolean[5][5];

        for(int i=0; i<5; i++){
            String str = br.readLine();
            for(int j=0; j<5; j++){
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0,0,-1);

        System.out.println(result);

    }
}