import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] mat;
    static int[][] distance;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int solve(int n){
        int count = 1;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int tmpY = tmp[0];
            int tmpX = tmp[1];
            for(int i=0; i<4; i++){
                int x = tmpX+dx[i];
                int y = tmpY+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && mat[y][x]==1 && distance[y][x]==0){
                    queue.offer(new int[] {y,x});
                    distance[y][x] = 1;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mat = new int[n][n];
        distance = new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                mat[i][j] = str.charAt(j)-'0';
            }
        }
        int count = 0;
        int index = 0;
        int[] countArray = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==1 && distance[i][j]==0){
                    queue.offer(new int[] {i,j});
                    distance[i][j] = 1;
                    count++;
                    countArray[index++] = solve(n);
                }
            }
        }
        Arrays.sort(countArray);
        System.out.println(count);
        for(int i=0; i<countArray.length; i++){
            if(countArray[i]!=0){
                System.out.println(countArray[i]);
            }
        }
    }
}
