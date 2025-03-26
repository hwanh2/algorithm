import java.io.*;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int k;
    static int count = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] visited;
    static void dfs(int x,int y,int depth){
        if(x==c-1 && y==0){
            if(depth==k){
                count++;
            }
            return;
        }
        if (depth >= k) return;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<c && ny<r && array[ny][nx]=='.' && visited[ny][nx]==0){
                visited[ny][nx] = 1;
                dfs(nx,ny,depth+1);
                visited[ny][nx] = 0;
            }
        }
    }
    static char[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new char[r][c];
        visited = new int[r][c];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                array[i][j] = str.charAt(j);
            }
        }
        visited[r-1][0] = 1;
        dfs(0,r-1,1);
        System.out.println(count);
    }

}

