import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            dp[i][i] = 1;
        }
        for(int i=1; i<n; i++){
            if(array[i]==array[i+1]){
                dp[i][i+1] = 1;
            }
        }
        for(int i=3; i<=n; i++){
            for(int start=1; start<=n-i+1; start++){
                int end = start+i-1;
                if(array[start]==array[end] && dp[start+1][end-1]==1){
                    dp[start][end] = 1;
                }
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            if(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]==1){
                sb.append(1).append("\n");
            }
            else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}