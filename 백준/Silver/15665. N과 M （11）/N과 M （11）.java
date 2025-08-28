import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int[] tmp;
    static int n;
    static int m;
    static StringBuilder sb;
    static void dfs(int num){
        if(num==m){
            for(int val : tmp){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int pre = 0;
        for(int i=0; i<=n; i++){
            if(pre != array[i]){
                tmp[num] = array[i];
                pre = array[i];
                dfs(num+1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n+1];
        tmp = new int[m];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        dfs(0);
        System.out.println(sb);

    }
}
