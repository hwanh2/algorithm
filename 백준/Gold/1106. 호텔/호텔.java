import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] array = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine()," ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[c+101][n+1];

        for (int i=0; i<=c+100; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        for (int j = 0; j <= n; j++) dp[0][j] = 0;

        for(int i=1; i<=c+100; i++){
            for(int j=1; j<=n; j++){
                int cost = array[j][0];
                int person = array[j][1];
                if(i>=person){
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-person][j]+cost);
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i=c; i<=c+100; i++) {
            answer = Math.min(answer, dp[i][n]);
        }
        System.out.println(answer);

    }
}