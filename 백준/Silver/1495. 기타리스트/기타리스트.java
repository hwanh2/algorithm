import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[n+1][m+1];

        st = new StringTokenizer(br.readLine()," ");
        int[] v = new int[n+1];
        for(int i=1; i<=n; i++){
            v[i] = Integer.parseInt(st.nextToken());
        }

        if(s+v[1]<=m){
            dp[1][s+v[1]] = true;
        }
        if(s-v[1]>=0){
            dp[1][s-v[1]] = true;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(dp[i-1][j]){
                    if(j+v[i]<=m){
                        dp[i][j+v[i]] = true;
                    }
                    if(j-v[i]>=0){
                        dp[i][j-v[i]] = true;
                    }
                }
            }
        }

        int result = -1;
        for(int i=0; i<=m; i++){
            if(dp[n][i]){
                result = i;
            }
        }
        System.out.println(result);
    }
}