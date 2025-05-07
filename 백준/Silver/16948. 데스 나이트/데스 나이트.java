import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] array;
    static Queue<int[]> queue;
    static int[] dx = {-1,1,-2,2,-1,1};
    static int[] dy = {-2,-2,0,0,2,2};
    static int bfs(int r2,int c2){
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]==r2 && tmp[1]==c2){
                return array[tmp[0]][tmp[1]];
            }

            for(int i=0; i<6; i++){
                int x = dx[i]+tmp[1];
                int y = dy[i]+tmp[0];
                if(x>=0 && x<n && y>=0 && y<n && array[y][x]==0){
                    queue.offer(new int[] {y,x});
                    array[y][x] = array[tmp[0]][tmp[1]]+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        queue = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        queue.offer(new int[] {r1,c1});
        System.out.println(bfs(r2,c2));
    }
}
