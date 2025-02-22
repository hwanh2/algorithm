import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dis;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void bfs(int n,int m){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];
            for(int i=0; i<4; i++){
                if(x+dx[i]>=0 && x+dx[i]<m && y+dy[i]>=0 && y+dy[i]<n && dis[y+dy[i]][x+dx[i]]==0){
                    queue.offer(new int[] {y+dy[i],x+dx[i]});
                    dis[y+dy[i]][x+dx[i]] = dis[y][x]+1;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int result = 0;
        dis = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dis[i][j] = sc.nextInt();
                if(dis[i][j] == 1){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        bfs(n,m);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dis[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result,dis[i][j]);
            }
        }
        System.out.println(result-1);
    }
}