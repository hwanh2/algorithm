import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int dfs(int x,int y){
        if(x==m-1 && y==n-1){
            return 1;
        }

        if(dp[y][x]==-1){
            dp[y][x] = 0;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && map[y][x]>map[ny][nx]){
                    dp[y][x] += dfs(nx,ny);
                }
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));

    }
}