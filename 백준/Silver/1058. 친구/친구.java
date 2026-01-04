import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static int max = Integer.MIN_VALUE;
    static int[] distance;
    static Queue<Integer> queue;
    static void bfs(int start){
        int count = 0;
        distance[start] = 1;
        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i=0; i<n; i++){
                if(distance[i]==0 && map[current][i]=='Y'){
                    distance[i] = distance[current]+1;
                    queue.add(i);
                    if(distance[i]<=3){
                        count++;
                    }
                }
            }
        }

        max = Math.max(max,count);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            distance = new int[n];
            queue = new LinkedList<>();
            queue.add(i);
            bfs(i);
        }

        System.out.println(max);

    }
}