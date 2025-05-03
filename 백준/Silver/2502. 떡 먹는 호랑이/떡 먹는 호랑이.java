import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[d];

        for(int i=1; i<=k/2; i++){
            for(int j=i+1; j<k; j++){
                dp[0] = i;
                dp[1] = j;
                for(int l=2; l<d; l++){
                    dp[l] = dp[l-1]+dp[l-2];
                }
                if(dp[d-1]==k){
                    sb.append(dp[0]).append("\n").append(dp[1]);
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}