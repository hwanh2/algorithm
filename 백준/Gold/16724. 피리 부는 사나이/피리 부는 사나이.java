import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char[][] map;
    static int[][] visited;
    static int count = 0;
    static void dfs(int r,int c){
        int nr = r;
        int nc = c;
        switch (map[r][c]){
            case 'D': nr++; break;
            case 'U': nr--; break;
            case 'R': nc++; break;
            case 'L': nc--; break;
        }

        if(visited[nr][nc]==0){
            visited[nr][nc] = 1;
            dfs(nr,nc);
        }
        else if(visited[nr][nc]==1){
            count++;
        }
        visited[r][c] = 2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0){
                    visited[i][j] = 1;
                    dfs(i,j);
                }
            }
        }

        System.out.println(count);

    }
}