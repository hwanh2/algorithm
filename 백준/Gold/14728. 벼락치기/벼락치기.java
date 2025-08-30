import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] time = new int[n+1];
        int[] point = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            time[i] = Integer.parseInt(st.nextToken());
            point[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[t+1][n+1];

        for(int i=1; i<=t; i++){
            for(int j=1; j<=n; j++){
                if(i<time[j]){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-time[j]][j-1]+point[j]);
                }
            }
        }
        System.out.println(dp[t][n]);
    }
}
