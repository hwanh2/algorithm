import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    static int[] w;
    static int[] v;
    static int[][] dp;
    static int solve(){
        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                if(i<w[j]){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-w[j]][j-1]+v[j]);
                }
            }
        }
        return dp[k][n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        w = new int[n+1];
        v = new int[n+1];
        dp = new int[k+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }
}
