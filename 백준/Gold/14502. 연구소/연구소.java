import java.io.*;
import java.util.*;

public class Main {
    static int[][] mat;
    static Queue<int[]> queue = new LinkedList<>();
    static int n;
    static int m;
    static int max = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void bfs(){
        int[][] copyMat = copyMat();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMat[i][j]==2){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<m && y<n && copyMat[y][x] == 0){
                    queue.offer(new int[] {y,x});
                    copyMat[y][x] = 2;
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMat[i][j]==0){
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
    static void backTracking(int depth){
        if(depth==3){
            bfs();
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    mat[i][j] = 1;
                    backTracking(depth+1);
                    mat[i][j] = 0;
                }
            }
        }
    }
    static int[][] copyMat(){
        int[][] tmp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tmp[i][j] = mat[i][j];
            }
        }
        return tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0);
        bw.write(max+"\n");
        bw.flush();

    }
}