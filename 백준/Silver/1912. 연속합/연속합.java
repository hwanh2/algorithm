import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int[] dp;
    static void solve(int n){
        for(int i=1; i<n; i++){
            if(dp[i-1]>0){
                dp[i] = array[i]+dp[i-1];
            }
            else{
                dp[i] = array[i];
            }
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
        dp[0] = array[0];
        solve(n);
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}