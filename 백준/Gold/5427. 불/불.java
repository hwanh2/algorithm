import java.io.*;
import java.util.*;

public class Main {
    static Character[][] array;
    static Queue<int[]> queue;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs(int n,int m){
        int count = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            int fire = tmp[2];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(fire == 1){
                    if(x>=0 && x<m && y>=0 && y<n && array[y][x]!='#' && array[y][x]!='*'){
                        queue.offer(new int[] {y,x,fire});
                        array[y][x] = '*';
                    }
                }
                if(fire == 0){
                    if(x>=0 && x<m && y>=0 && y<n && array[y][x]=='.'){
                        visited[y][x] = visited[tmpY][tmpX]+1;
                        if(x==0 || x==m-1 || y==0 || y==n-1){
                            return visited[y][x]+1;
                        }
                        queue.offer(new int[] {y,x,fire});
                        array[y][x] = '@';
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            array = new Character[n][m];
            visited = new int[n][m];
            int flag = 0;
            for(int j=0; j<n; j++){
                String tmp = br.readLine();
                for(int k=0; k<m; k++){
                    array[j][k] = tmp.charAt(k);
                    if(array[j][k]=='*'){
                        queue.offer(new int[] {j,k,1});
                        visited[j][k]=1;
                    }
                    if(array[j][k]=='#'){
                        visited[j][k]=1;
                    }
                }
            }
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(array[j][k]=='@'){
                        if(j==0||j==n-1||k==0||k==m-1){
                            bw.write(1+"\n");
                            bw.flush();
                            flag = 1;
                            continue;
                        }
                        queue.offer(new int[] {j,k,0});
                    }
                }
            }
            if(flag == 1){
                continue;
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
}
