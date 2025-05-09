import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;
    static int[][] dp;
    static int solve(){
        int max = dp[0][0];
        for(int i=1; i<n; i++){
            dp[0][i] = Math.max(dp[0][i-1]+array[i],array[i]);
            dp[1][i] = Math.max(dp[1][i-1]+array[i],dp[0][i-1]);
            max = Math.max(max,Math.max(dp[0][i],dp[1][i]));
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n];
        dp = new int[2][n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = array[0];
        dp[1][0] = 0;

        System.out.println(solve());

    }

}