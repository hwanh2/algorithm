import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // x
        int n = sc.nextInt(); // y
        Queue<int[]> queue = new LinkedList<>();
        int[][] array = new int[n][m];
        int[][] visited = new int[n][m];
        int count = 0;
        int flag = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j] = sc.nextInt();
                if(array[i][j]==1){
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
                else if(array[i][j]==-1){
                    visited[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0]+1<n && array[tmp[0]+1][tmp[1]]!=-1 && visited[tmp[0]+1][tmp[1]] != 1){
                queue.offer(new int[]{tmp[0]+1,tmp[1],tmp[2]+1});
                visited[tmp[0]+1][tmp[1]] = 1;
                count = tmp[2]+1;
            }
            if(tmp[0]-1>=0 && array[tmp[0]-1][tmp[1]]!=-1 && visited[tmp[0]-1][tmp[1]] != 1){
                queue.offer(new int[]{tmp[0]-1,tmp[1],tmp[2]+1});
                visited[tmp[0]-1][tmp[1]] = 1;
                count = tmp[2]+1;
            }
            if(tmp[1]+1<m && array[tmp[0]][tmp[1]+1]!=-1 && visited[tmp[0]][tmp[1]+1] != 1){
                queue.offer(new int[]{tmp[0],tmp[1]+1,tmp[2]+1});
                visited[tmp[0]][tmp[1]+1] = 1;
                count = tmp[2]+1;
            }
            if(tmp[1]-1>=0 && array[tmp[0]][tmp[1]-1]!=-1 && visited[tmp[0]][tmp[1]-1] != 1){
                queue.offer(new int[]{tmp[0],tmp[1]-1,tmp[2]+1});
                visited[tmp[0]][tmp[1]-1] = 1;
                count = tmp[2]+1;
            }

        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0){
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0){
            System.out.println(count);
        }
        else{
            System.out.println(-1);
        }

    }
}