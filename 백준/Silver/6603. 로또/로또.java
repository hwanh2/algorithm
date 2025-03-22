import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int[] tmp;
    static StringBuilder sb;
    static int k;
    static void dfs(int depth, int start){
        if(depth==6){
            for(int i=0; i<tmp.length; i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<k; i++){
            tmp[depth] = array[i];
            dfs(depth+1,i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;

            array = new int[k];
            tmp = new int[6];
            for(int i=0; i<k; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}