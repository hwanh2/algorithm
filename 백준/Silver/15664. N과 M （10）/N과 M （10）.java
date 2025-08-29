import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int[] tmp;
    static StringBuilder sb;
    static int[] visited;
    static void dfs(int start,int depth){
        if(depth==m){
            for(int i=0; i<m; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;
        for(int i=start; i<n; i++){
            if(before!=array[i] && visited[i]==0){
                visited[i] = 1;
                tmp[depth] = array[i];
                before = array[i];
                dfs(i,depth+1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        tmp = new int[m];
        visited = new int[n];
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        dfs(0,0);

        System.out.println(sb);
    }
}
