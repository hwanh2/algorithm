import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] hp;
    static int[] happy;
    static int[][] dp;
    static void solve(){
        for(int i=1; i<=100; i++){
            for(int j=1; j<=n; j++){
                if(i>hp[j]){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-hp[j]][j-1]+happy[j]);
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        hp = new int[n+1];
        happy = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=n; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=n; i++){
            happy[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[101][n+1];

        solve();

        System.out.println(dp[100][n]);
    }
}
