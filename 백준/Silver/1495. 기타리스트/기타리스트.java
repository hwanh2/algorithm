import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];

        dp[0][S] = true;

        for (int i=1; i<=N; i++) {
            for (int j=0; j<=M; j++) {
                if (dp[i-1][j]) {
                    int plusVol = j+V[i];
                    int minusVol = j-V[i];

                    if (plusVol<=M) {
                        dp[i][plusVol] = true;
                    }
                    if (minusVol>=0) {
                        dp[i][minusVol] = true;
                    }
                }
            }
        }

        int result = -1;
        for (int j=M; j >= 0; j--) {
            if (dp[N][j]) {
                result = j;
                break;
            }
        }

        System.out.println(result);
    }
}