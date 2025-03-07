import java.io.*;
import java.util.*;

public class Main {
    static int[][] array;
    static int[][] dp;
    static int solve(int n){
        for(int i=2; i<=n; i++){
            dp[0][i] = Math.max(dp[1][i-1],Math.max(dp[0][i-2],dp[1][i-2]))+array[0][i];
            dp[1][i] = Math.max(dp[0][i-1],Math.max(dp[0][i-2],dp[1][i-2]))+array[1][i];
        }
        return Math.max(dp[0][n],dp[1][n]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            array = new int[2][n+1];
            dp = new int[2][n+1];
            for(int j=0; j<2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int k=1; k<=n; k++){
                    array[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = array[0][1];
            dp[1][1] = array[1][1];
            bw.write(solve(n)+"\n");
        }
        bw.flush();
    }
}
