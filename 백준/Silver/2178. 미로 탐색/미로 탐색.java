import java.util.*;

public class Main {
    static int[][] array;
    static int[][] distance;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> queue = new LinkedList<>();
    static void bfs(int n,int m){
        queue.offer(new int[] {0,0});
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[1];
            int y = tmp[0];
            for(int i=0; i<4; i++){
                if(x+dx[i]<m && x+dx[i]>=0 && y+dy[i]<n && y+dy[i]>=0 && array[y+dy[i]][x+dx[i]]==1 && distance[y+dy[i]][x+dx[i]]==0){
                    distance[y+dy[i]][x+dx[i]] = distance[y][x]+1;
                    queue.offer(new int[] {y+dy[i],x+dx[i]});
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        array = new int[n][m];
        distance = new int[n][m];
        String[] input = new String[n];
        for(int i=0; i<n; i++){
            input[i] = sc.next();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j] = input[i].charAt(j)-'0';
            }
        }
        bfs(n,m);

        System.out.println(distance[n-1][m-1]+1);
    }
}
