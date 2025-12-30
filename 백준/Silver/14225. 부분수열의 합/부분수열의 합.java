import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[] s;
    static boolean[] check;
    static void dfs(int depth, int sum){
        if(depth==n){
            check[sum] = true;
            return;
        }
        dfs(depth+1,sum+s[depth]);
        dfs(depth+1,sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        s = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            s[i] = Integer.parseInt(st.nextToken());
            sum += s[i];
        }

        check = new boolean[sum+2];

        dfs(0,0);

        int result = 0;
        for(int i=1; i<=sum+1; i++){
            if(!check[i]){
                result = i;
                break;
            }
        }

        System.out.println(result);
        
        
    }
}