import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][][] distance;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] dz = {1,-1};
    static void bfs(int n,int m,int h){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[2];
            int y = tmp[1];
            int z = tmp[0];
            for(int i=0; i<4; i++){
                if(x+dx[i]>=0 && x+dx[i]<m && y+dy[i]>=0 && y+dy[i]<n && distance[z][y+dy[i]][x+dx[i]]==0){
                    queue.offer(new int[] {z,y+dy[i],x+dx[i]});
                    distance[z][y+dy[i]][x+dx[i]] = distance[z][y][x]+1;
                }
            }
            for(int i=0; i<2; i++){
                if(z+dz[i]!=h && z+dz[i]>=0 && distance[z+dz[i]][y][x]==0){
                    queue.offer(new int[] {z+dz[i],y,x});
                    distance[z+dz[i]][y][x] = distance[z][y][x]+1;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        distance = new int[h][n][m];
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    distance[i][j][k] = sc.nextInt();
                    if(distance[i][j][k] == 1){
                        queue.offer(new int[] {i,j,k});
                    }
                }
            }
        }
        bfs(n,m,h);
        int result = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(distance[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(distance[i][j][k],result);
                }
            }
        }
        System.out.println(result-1);
    }
}