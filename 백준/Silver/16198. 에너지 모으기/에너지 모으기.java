import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static int max = 0;
    static boolean[] visited;
    static void dfs(int depth, int sum){
        if(depth==n-2){
            max = Math.max(max,sum);
            return;
        }

        for(int i=1; i<n-1; i++){
            if(!visited[i]){
                visited[i] = true;
                int start = findStart(i);
                int end = findEnd(i);
                dfs(depth+1,sum+array[start]*array[end]);
                visited[i] = false;
            }
        }
    }

    static int findStart(int index){
        for(int i=index-1; i>=0; i--){
            if(!visited[i]){
                return i;
            }
        }
        return 0;
    }
    static int findEnd(int index){
        for(int i=index+1; i<n; i++){
            if(!visited[i]){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(max);


    }
}