import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            dp[i][0] = 10000;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i<j){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-j][j]+array[j]);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
