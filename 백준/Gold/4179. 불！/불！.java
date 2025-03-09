import java.io.*;
import java.util.*;

public class Main {
    static Character[][] array;
    static Queue<int[]> queue;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs(int n,int m){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            int fire = tmp[2];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(fire == 1){
                    if(x>=0 && x<m && y>=0 && y<n && array[y][x]!='#' && array[y][x]!='F'){
                        queue.offer(new int[] {y,x,fire});
                        array[y][x] = 'F';
                    }
                }
                if(fire == 0){
                    if(x>=0 && x<m && y>=0 && y<n && array[y][x]=='.'){
                        visited[y][x] = visited[tmpY][tmpX]+1;
                        if(x==0 || x==m-1 || y==0 || y==n-1){
                            return visited[y][x]+1;
                        }
                        queue.offer(new int[] {y,x,fire});
                        array[y][x] = 'J';
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        array = new Character[n][m];
        visited = new int[n][m];

        for(int j=0; j<n; j++){
            String tmp = br.readLine();
            for(int k=0; k<m; k++){
                array[j][k] = tmp.charAt(k);
                if(array[j][k]=='F'){
                    queue.offer(new int[] {j,k,1});
                }
            }
        }
        for(int j=0; j<n; j++){
            for(int k=0; k<m; k++){
                if(array[j][k]=='J'){
                    if(j==0||j==n-1||k==0||k==m-1){
                        bw.write(1+"\n");
                        bw.flush();
                        return;
                    }
                    queue.offer(new int[] {j,k,0});
                }
            }
        }
        int result = bfs(n,m);
        if(result==-1){
            bw.write("IMPOSSIBLE"+"\n");
        }
        else{
            bw.write(result+"\n");
        }
        bw.flush();

    }
}
