import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int l=0; l<t; l++){
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=n; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            int[][] dp = new int[m+1][n+1];

            for(int i=0; i<=n; i++){
                dp[0][i] = 1;
            }

            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    if(i>=coin[j]){
                        dp[i][j] = dp[i][j-1]+dp[i-coin[j]][j];
                    }
                    else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}