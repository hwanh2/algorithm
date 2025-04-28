import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int n;
    static int m;
    static int max = 0;
    static boolean[] visited;
    static int[][] distance;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void dfs(int x, int y){
        visited[map[y][x]-'A'] = true;

        for(int i=0; i<4; i++){
            int px = x+dx[i];
            int py = y+dy[i];
            if(px>=0 && py>=0 && px<m && py<n && visited[map[py][px]-'A'] == false){
                distance[py][px] = distance[y][x]+1;
                max = Math.max(max,distance[py][px]);
                dfs(px,py);
                visited[map[py][px]-'A'] = false;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        map = new char[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0);
        
        System.out.println(max+1);

    }
}
