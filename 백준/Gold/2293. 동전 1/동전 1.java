import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];

        for(int i=1; i<=n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[k+1][n+1];

        for(int i=0; i<=n; i++){
            dp[0][i] = 1;
        }

        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                if(i<coin[j]){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1]+dp[i-coin[j]][j];
                }
            }
        }

        System.out.println(dp[k][n]);

    }
}
