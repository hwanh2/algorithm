import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] day = new int[m+1];
        int[] chap = new int[m+1];
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine()," ");
            day[i] = Integer.parseInt(st.nextToken());
            chap[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i<day[j]){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-day[j]][j-1]+chap[j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
