import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int[] dp;
    static void solve(int n){
        dp[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(array[j]<array[i]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solve(n);
        int result = dp[0];
        for(int i=1; i<n; i++){
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
}

