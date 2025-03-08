import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static Queue<int[]> queue;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void bfs(int n,int m){
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && x<m && y>=0 && y<n && array[y][x]==1 && visited[y][x]==0){
                    queue.offer(new int[] {y,x});
                    visited[y][x] = 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            array = new int[n][m];
            visited = new int[n][m];
            queue = new LinkedList<>();
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                array[y][x] = 1;
            }
            int count = 0;
            for(int j=0; j<n; j++){
                for(int l=0; l<m; l++){
                    if(array[j][l]==1 && visited[j][l]==0){
                        queue.offer(new int[] {j,l});
                        bfs(n,m);
                        visited[j][l] = 1;
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
