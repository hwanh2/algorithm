import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] point = new int[k+1];
        int[] time = new int[k+1];
        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=k; i++){
            st = new StringTokenizer(br.readLine()," ");
            point[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(i-time[j]>=0){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-time[j]][j-1]+point[j]);
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}