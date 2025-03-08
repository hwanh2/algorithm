import java.io.*;

public class Main {
    static int[] dp;
    static int solve(int n){
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2]+dp[i-1])%15746;
        }
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            bw.write(1+"\n");
            bw.flush();
            return;
        }
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        bw.write(solve(n)+"\n");
        bw.flush();
    }
}