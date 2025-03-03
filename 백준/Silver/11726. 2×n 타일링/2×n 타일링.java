import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int solve(){
        for(int i=2; i<dp.length; i++){
            dp[i] = (dp[i-2]+dp[i-1])%10007;
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        bw.write(solve()+"\n");
        bw.close();
    }
}