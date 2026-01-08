import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] coin = new int[k+1];
        int[] count = new int[k+1];
        for(int i=1; i<=k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            coin[i] = Integer.parseInt(st.nextToken());
            count[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[t+1][k+1];

        for(int i=0; i<=k; i++){
            dp[0][i] = 1;
        }

        for(int i=1; i<=t; i++){
            for(int j=1; j<=k; j++){
                int coinValue = coin[j];
                int coinCount = count[j];
                for(int l=0; l<=coinCount; l++){
                    int remain = i-(coinValue*l);
                    if(remain<0){
                        break;
                    }

                    dp[i][j] += dp[remain][j-1];
                }
            }
        }
        System.out.println(dp[t][k]);
    }

}