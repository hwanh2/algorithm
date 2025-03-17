import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] array;
    static void solve(int n){
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(array[i]>array[j] && max<dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = array[i] + max;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = array[0];
        solve(n);
        int result = dp[0];
        for(int i=1; i<n; i++){
            result = Math.max(result,dp[i]);
        }
        bw.write(result+"\n");
        bw.flush();
    }
}