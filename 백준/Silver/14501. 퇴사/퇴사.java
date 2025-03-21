import java.io.*;
import java.util.*;

public class Main {
    static int[] t;
    static int[] p;
    static int[] dp;
    static void solve(int n){
        for(int i=1; i<n; i++){
            if(i+t[i]<=n){
                dp[i] = p[i];
            }
            for(int j=0; j<i; j++){
                if(i+t[i]<=n && i>=j+t[j]){
                    dp[i] = Math.max(dp[j]+p[i],dp[i]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        dp = new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        if(t[0]<=n){
            dp[0] = p[0];
        }
        else{
            dp[0] = 0;
        }
        solve(n);
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}