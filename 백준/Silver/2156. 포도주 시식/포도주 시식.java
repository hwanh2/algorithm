import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int[] dp;
    static int max = 0;
    static void solve(int n){
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(Math.max(dp[i-1],dp[i-2]+array[i]),dp[i-3]+array[i-1]+array[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        dp = new int[n+1];

        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(array[1]);
            return;
        }
        
        dp[1] = array[1];
        dp[2] = array[1]+array[2];

        solve(n);
        System.out.println(dp[n]);

    }
}

