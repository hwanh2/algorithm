import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] array;
    static int[][] dp;
    static int INF = 1000*1000;
    static int solve(int start){
        dp = new int[n][3];
        for(int i=0; i<3; i++){
            if(i==start){
                dp[0][i] = array[0][i];
            }
            else{
                dp[0][i] = INF;
            }
        }
        for(int i=1; i<n; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+array[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+array[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+array[i][2];
        }

        int result = INF;
        for(int i=0; i<3; i++){
            if(i!=start){
                result = Math.min(result,dp[n-1][i]);
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new int[n][3];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<3; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            result = Math.min(result,solve(i));
        }

        System.out.println(result);

    }
}