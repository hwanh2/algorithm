import java.io.*;
import java.util.*;

public class Main {
    static long[] dp = new long[101];
    static void solve(int n){
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for(int i=6; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            solve(n);
            System.out.println(dp[n]);
        }
    }
}