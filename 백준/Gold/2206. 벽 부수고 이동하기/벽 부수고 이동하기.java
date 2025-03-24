import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[][][] distance;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Node> queue = new LinkedList<>();
    static int bfs(int n,int m){
        queue.offer(new Node(0,0,1,false));
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            int tmpX = tmp.x;
            int tmpY = tmp.y;
            int cnt = tmp.cnt;
            boolean isWall = tmp.isWall;
            for(int i=0; i<4; i++){ // 상하좌우 이동
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<m && y<n){
                    if(x==m-1 && y==n-1){
                        return cnt+1;
                    }
                    if(isWall){ // 벽을 부쉈을 경우
                        if(array[y][x]==0 && distance[y][x][1]==0){
                            queue.offer(new Node(x,y,cnt+1,true));
                            distance[y][x][1] = 1;
                        }
                    }
                    else{ // 벽을 안 부쉈을 경우
                        if(array[y][x]==0 && distance[y][x][0]==0){
                            queue.offer(new Node(x,y,cnt+1,false));
                            distance[y][x][0] = 1;
                        }
                        else if(array[y][x]==1){
                            queue.offer(new Node(x,y,cnt+1,true));
                            distance[y][x][1] = 1;
                            distance[y][x][0] = 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        array = new int[n][m];
        distance = new int[n][m][2];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                array[i][j] = str.charAt(j)-'0';
            }
        }
        if(n==1 && m==1){
            System.out.println(1);
            return;
        }
        System.out.println(bfs(n,m));
    }
}
class Node{
    public int x;
    public int y;
    public int cnt;
    public boolean isWall;

    public Node(int x, int y, int cnt, boolean isWall) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.isWall = isWall;
    }
}