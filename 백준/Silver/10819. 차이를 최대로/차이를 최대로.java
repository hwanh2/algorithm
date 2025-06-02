import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] array;
    static int[] tmp;
    static int max = Integer.MIN_VALUE;
    static int[] visited;
    static void backTracking(int depth){
        if(n==depth){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                sum+=Math.abs(tmp[i]-tmp[i+1]);
            }
            max = Math.max(max,sum);
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                visited[i] = 1;
                tmp[depth] = array[i];
                backTracking(depth+1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        tmp = new int[n];
        visited = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        System.out.println(max);

    }
}
