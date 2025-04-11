import java.io.*;
import java.util.*;

public class Main {
    static int l;
    static int r;
    static int c;
    static char[][][] mat;
    static int[][][] distance;
    static Queue<int[]> queue;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] dz = {1,-1};
    static String bfs(){
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[2];
            int tmpY = tmp[1];
            int tmpZ = tmp[0];
            if(mat[tmpZ][tmpY][tmpX]=='E'){
                return "Escaped in "+(distance[tmpZ][tmpY][tmpX]-1)+" minute(s).";
            }
            for(int i=0; i<2; i++){
                int x = tmpX;
                int y = tmpY;
                int z = tmpZ+dz[i];
                if(x>=0 && y>=0 && z>=0 && x<c && y<r && z<l && distance[z][y][x]==0){
                    if(mat[z][y][x]=='.' || mat[z][y][x]=='E'){
                        queue.offer(new int[] {z,y,x});
                        distance[z][y][x] = distance[tmpZ][tmpY][tmpX]+1;
                    }
                }
            }
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                int z = tmpZ;
                if(x>=0 && y>=0 && z>=0 && x<c && y<r && z<l && distance[z][y][x]==0){
                    if(mat[z][y][x]=='.' || mat[z][y][x]=='E'){
                        queue.offer(new int[] {z,y,x});
                        distance[z][y][x] = distance[tmpZ][tmpY][tmpX]+1;
                    }
                }
            }
        }
        return "Trapped!";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(l==0 && r==0 && c==0){
                System.out.println(sb);
                break;
            }
            mat = new char[l][r][c];
            distance = new int[l][r][c];
            queue = new LinkedList<>();

            for(int i=0; i<l; i++){
                for(int j=0; j<r; j++){
                    String str = br.readLine();
                    for(int k=0; k<c; k++){
                        mat[i][j][k] = str.charAt(k);
                        if(mat[i][j][k]=='S'){
                            queue.offer(new int[] {i,j,k});
                            distance[i][j][k] = 1;
                        }
                    }
                }
                br.readLine();
            }
            sb.append(bfs()).append("\n");
        }
    }
}

