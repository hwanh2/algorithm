import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int l=0; l<t; l++){
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=n; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            int[][] dp = new int[m+1][n+1];
            for(int i=0; i<=n; i++){
                dp[0][i] = 1;
            }
            for(int i=1; i<=m; i++){
                for(int j=1; j<=n; j++){
                    if(i<array[j]){
                        dp[i][j] = dp[i][j-1];
                    }
                    else{
                        dp[i][j] =dp[i][j-1]+dp[i-array[j]][j];
                    }
                }
            }
            sb.append(dp[m][n]).append("\n");
        }
        System.out.println(sb);
    }
}