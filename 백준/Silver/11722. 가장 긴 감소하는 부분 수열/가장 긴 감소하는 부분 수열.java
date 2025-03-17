import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] array;
    static void solve(int n){
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(array[i]<array[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max+1;
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
        dp[0] = 1;
        solve(n);
        Arrays.sort(dp);
        bw.write(dp[n-1]+"\n");
        bw.flush();
    }
}