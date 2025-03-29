import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] array;
    static int[] tmp;
    static StringBuilder sb;
    static void dfs(int depth,int start){
        if(depth==m){
            for(int i=0; i<tmp.length; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;
        for(int i=start; i<n; i++){
            if(array[i]!=before){
                tmp[depth] = before = array[i];
                dfs(depth+1,i);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        tmp = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        dfs(0,0);
        System.out.println(sb);
    }
}

