import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] mat;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void solve(int n,int m){
        int count = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && x<m && y>=0 && y<n && mat[y][x]!='X' && visited[y][x]==0){
                    if(mat[y][x]=='P'){
                        count++;
                    }
                    queue.offer(new int[] {y,x});
                    visited[y][x] = 1;
                }
            }
        }
        if(count==0){
            System.out.println("TT");
        }
        else{
            System.out.println(count);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        mat = new char[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                mat[i][j] = line.charAt(j);
                if(mat[i][j]=='I'){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        solve(n,m);
    }
}
